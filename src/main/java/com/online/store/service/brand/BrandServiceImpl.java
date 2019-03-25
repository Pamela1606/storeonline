package com.online.store.service.brand;

import com.online.store.models.Brand;
import com.online.store.reporsitory.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandConverter brandConverter;

    @Override
    public Page<BrandDto> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable).map(brandConverter::toDto);
    }

    @Override
    public BrandDto createEntity(BrandDto brandDto) {
        Brand brand = brandRepository.save(brandConverter.toModel(brandDto));
        return brandConverter.toDto(brand);
    }

    @Override
    public BrandDto updateEntity(BrandDto brandDto) {
        Optional<Brand> brandOptional = brandRepository.findById(brandDto.getId());
        if (!brandOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Brand with %d not exist.", brandDto.getId()));
        }
        brandRepository.save(brandConverter.toModel(brandDto));
        return brandDto;
    }

    @Override
    public BrandDto deleteEntity(Long id) {
        Optional<Brand> brandOptional = brandRepository.findById(id);
        if (!brandOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Brand with %d not exist.", id));
        }
        brandRepository.delete(brandOptional.get());
        return brandConverter.toDto(brandOptional.get());
    }
}

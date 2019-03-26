package com.online.store.service.saleDetail;

import com.online.store.models.SaleDetail;
import com.online.store.reporsitory.SaleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class SaleDetailServiceImpl implements SaleDetailService {

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    @Autowired
    private SaleDetailConverter saleDetailConverter;

    @Override
    public Page<SaleDetailDto> findAll(Pageable pageable) {
        return saleDetailRepository.findAll(pageable).map(saleDetailConverter::toDto);
    }

    @Override
    public SaleDetailDto createEntity(SaleDetailDto saleDetailDto) {
        SaleDetail saleDetail = saleDetailRepository.save(saleDetailConverter.toModel(saleDetailDto));
        return saleDetailConverter.toDto(saleDetail);
    }

    @Override
    public SaleDetailDto updateEntity(SaleDetailDto saleDetailDto) {
        Optional<SaleDetail> saleDetailOptional = saleDetailRepository.findById(saleDetailDto.getId());
        if (!saleDetailOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The SaleDetail with %d not exist.", saleDetailDto.getId()));
        }
        saleDetailRepository.save(saleDetailConverter.toModel(saleDetailDto));
        return saleDetailDto;
    }

    @Override
    public SaleDetailDto deleteEntity(Long id) {
        Optional<SaleDetail> saleDetailOptional = saleDetailRepository.findById(id);
        if (!saleDetailOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The SaleDetail with %d not exist.", id));
        }
        saleDetailRepository.delete(saleDetailOptional.get());
        return saleDetailConverter.toDto(saleDetailOptional.get());
    }
}

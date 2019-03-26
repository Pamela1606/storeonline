package com.online.store.service.saleDetail;

import com.online.store.models.Item;
import com.online.store.models.Sale;
import com.online.store.models.SaleDetail;
import com.online.store.reporsitory.*;
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
    private ItemRepository itemRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleDetailConverter saleDetailConverter;

    @Override
    public Page<SaleDetailDto> findAll(Pageable pageable) {
        return saleDetailRepository.findAll(pageable).map(saleDetailConverter::toDto);
    }

    @Override
    public SaleDetailDto createEntity(SaleDetailDto saleDetailDto) {
        Optional<Item> itemOptional = itemRepository.findById(saleDetailDto.getItemId());
        if (!itemOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Item with %d not exist.", saleDetailDto.getItemId()));
        }
        Optional<Sale> saleOptional = saleRepository.findById(saleDetailDto.getSaleId());
        if (!saleOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Sale with %d not exist.", saleDetailDto.getSaleId()));
        }
        SaleDetail saleDetail = saleDetailConverter.toModel(saleDetailDto);
        saleDetail.setItem(itemOptional.get());
        saleDetail.setSale(saleOptional.get());
        saleDetailRepository.save(saleDetail);
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

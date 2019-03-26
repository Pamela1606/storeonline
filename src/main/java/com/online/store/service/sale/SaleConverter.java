package com.online.store.service.sale;

import com.online.store.models.Sale;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaleConverter {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Convert SaleDto to Sale
     *
     * @param saleDto a SaleDto
     * @return a Sale entity
     */
    public Sale toModel(SaleDto saleDto) {
        return modelMapper.map(saleDto, Sale.class);
    }

    /**
     * Convert Sale to SaleDto
     *
     * @param sale a Sale
     * @return a SaleDto entity
     */
    public SaleDto toDto(Sale sale) {
        return modelMapper.map(sale, SaleDto.class);
    }
}

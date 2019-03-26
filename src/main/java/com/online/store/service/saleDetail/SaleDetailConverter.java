package com.online.store.service.saleDetail;

import com.online.store.models.SaleDetail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaleDetailConverter {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Convert SaleDetailDto to SaleDetail
     *
     * @param saleDetailDto a SaleDetailDto
     * @return a SaleDetail entity
     */
    public SaleDetail toModel(SaleDetailDto saleDetailDto) {
        return modelMapper.map(saleDetailDto, SaleDetail.class);
    }

    /**
     * Convert SaleDetail to SaleDetailDto
     *
     * @param saleDetail a SaleDetail
     * @return a SaleDetailDto entity
     */
    public SaleDetailDto toDto(SaleDetail saleDetail) {
        return modelMapper.map(saleDetail, SaleDetailDto.class);
    }
}

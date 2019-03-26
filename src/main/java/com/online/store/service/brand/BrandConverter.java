package com.online.store.service.brand;

import com.online.store.models.Brand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrandConverter {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Convert CategoryDto to Brand
     *
     * @param brandDto a CategoryDto
     * @return a Brand entity
     */
    public Brand toModel(BrandDto brandDto) {
        return modelMapper.map(brandDto, Brand.class);
    }

    /**
     * Convert Brand to CategoryDto
     *
     * @param brand a Brand
     * @return a CategoryDto entity
     */
    public BrandDto toDto(Brand brand) {
        return modelMapper.map(brand, BrandDto.class);
    }
}

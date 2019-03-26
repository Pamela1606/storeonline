package com.online.store.service.category;

import com.online.store.models.Category;
import com.online.store.reporsitory.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public Page<CategoryDto> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(categoryConverter::toDto);
    }

    @Override
    public CategoryDto createEntity(CategoryDto categoryDto) {
        Category category = categoryRepository.save(categoryConverter.toModel(categoryDto));
        return categoryConverter.toDto(category);
    }

    @Override
    public CategoryDto updateEntity(CategoryDto categoryDto) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryDto.getId());
        if (!categoryOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Category with %d not exist.", categoryDto.getId()));
        }
        categoryRepository.save(categoryConverter.toModel(categoryDto));
        return categoryDto;
    }

    @Override
    public CategoryDto deleteEntity(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (!categoryOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Category with %d not exist.", id));
        }
        categoryRepository.delete(categoryOptional.get());
        return categoryConverter.toDto(categoryOptional.get());
    }
}

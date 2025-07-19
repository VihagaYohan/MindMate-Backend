package com.codenova.mindmate_backend.services;

import com.codenova.mindmate_backend.dtos.CategoryDto;
import com.codenova.mindmate_backend.exceptions.NoResourceException;
import com.codenova.mindmate_backend.mappers.CategoryMapper;
import com.codenova.mindmate_backend.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    // get all categories
    public Iterable<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .filter(category -> category.getIsActive() == true)
                .map(category -> categoryMapper.toDto(category))
                .toList();
    }

    // get a single category by Id
    public CategoryDto getCategoryById(Long id) {
        var category = categoryRepository.findById(id).orElseThrow(() ->
                new NoResourceException(String.format("Category with id %s not found", id)));
        return categoryMapper.toDto(category);
    }

    // create new category
    public CategoryDto  addCategory(CategoryDto categoryDto) {
        var category = categoryMapper.toEntity(categoryDto);
        categoryRepository.save(category);
        categoryDto.setId(category.getId());
        return categoryDto;
    }

    // update category
    public CategoryDto updateCategory(
            Long id,
            CategoryDto categoryDto
    ) {
        var category = categoryRepository.findById(id).orElseThrow(() ->
                new NoResourceException(String.format("Category with id %s not found", id)));

        categoryMapper.update(categoryDto, category);
        categoryRepository.save(category);
        categoryDto.setId(category.getId());

        return categoryMapper.toDto(category);
    }

    // delete category
    public String deleteCategory(Long id) {
        var category = categoryRepository.findById(id).orElseThrow(() ->
                new NoResourceException(String.format("Category with id %s not found", id)));

        var categoryDto = categoryMapper.toDto(category);
        categoryDto.setId(category.getId());
        categoryDto.setIsActive(false);

        categoryMapper.update(categoryDto, category);
        categoryRepository.save(category);
        categoryDto.setId(category.getId());

        return String.format("Category with id %s has been deleted", id);
    }
}

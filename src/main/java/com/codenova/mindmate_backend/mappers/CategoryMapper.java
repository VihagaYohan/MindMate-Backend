package com.codenova.mindmate_backend.mappers;

import com.codenova.mindmate_backend.dtos.CategoryDto;
import com.codenova.mindmate_backend.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target="isActive", source="isActive")
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);

    @Mapping(target="id", ignore = true)
    void update(CategoryDto categoryDto, @MappingTarget Category category);
}

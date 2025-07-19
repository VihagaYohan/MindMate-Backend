package com.codenova.mindmate_backend.controllers;

import com.codenova.mindmate_backend.dtos.CategoryDto;
import com.codenova.mindmate_backend.dtos.SuccessResponse;
import com.codenova.mindmate_backend.mappers.CategoryMapper;
import com.codenova.mindmate_backend.repositories.CategoryRepository;
import com.codenova.mindmate_backend.services.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    // fetch all categories
    @GetMapping
    public ResponseEntity<SuccessResponse<?>> getAllCategories() {
        var categoryList = categoryService.getAllCategories();
        var successResponse = new SuccessResponse<List<CategoryDto>>().builder()
                .status(HttpStatus.OK.value())
                .message("List of categories")
                .data(categoryList)
                .build();

        return ResponseEntity.ok(successResponse);
    }

    // fetch category by category id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable(name="id") Long id){
        var categoryDto = categoryService.getCategoryById(id);
        return ResponseEntity.ok().body(categoryDto);
    }

    // create a new category
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
           @Valid @RequestBody CategoryDto request,
            UriComponentsBuilder uriBuilder
    ) {
       var categoryDto = categoryService.addCategory(request);

        var uri  = uriBuilder.path("/categories/{id}").buildAndExpand(categoryDto.getId()).toUri();

        return ResponseEntity.created(uri).body(categoryDto);
    }

    // update a category
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto>updateCategory(
            @PathVariable(name="id") Long id,
            @Valid @RequestBody CategoryDto request
    ) {
        var categoryDto = categoryService.updateCategory(id, request);
        return ResponseEntity.ok().body(categoryDto);
    }

    // delete a category
    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse<?>> deleteCategory(
            @PathVariable(name="id") Long id
    ) {
        var result = categoryService.deleteCategory(id);
        SuccessResponse<Object> response = new SuccessResponse<>().builder()
                .status(HttpStatus.OK.value())
                .message(result)
                .data(null)
                .build();

        return ResponseEntity.ok().body(response);
    }
}

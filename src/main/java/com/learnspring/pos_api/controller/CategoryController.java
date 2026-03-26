package com.learnspring.pos_api.controller;

import com.learnspring.pos_api.dto.ApiResponse;
import com.learnspring.pos_api.model.Category;
import com.learnspring.pos_api.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponse<List<Category>> getAll() {
        return new ApiResponse<>("Success", "Success get category.", service.getAll());
    }

    @PostMapping
    public ApiResponse<Category> create(@RequestBody Category category) {
        return new ApiResponse<>(
                "success",
                "Category created successfully",
                service.create(category)
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<Category> update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return new ApiResponse<>("success", "Category updated succesfully", service.create(category));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ApiResponse<>("success", "Category berhasil dihapus", null);
    }
}

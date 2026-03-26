package com.learnspring.pos_api.controller;

import com.learnspring.pos_api.dto.ApiResponse;
import com.learnspring.pos_api.dto.ProductRequest;
import com.learnspring.pos_api.model.Product;
import com.learnspring.pos_api.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponse<List<Product>> getAll() {
        return new ApiResponse<>("success", "Success get products", service.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Product> getById(@PathVariable Long id) {
        return new ApiResponse<>("success", "Succesfully get product.", service.getById(id));
    }

    @PostMapping
    public ApiResponse<Product> create(@RequestBody ProductRequest request){
        return new ApiResponse<>(
                "success",
                "Product created",
                service.create(request)
        );
    }
    @PutMapping("/{id}")
    public ApiResponse<Product> update(
            @PathVariable Long id,
            @RequestBody ProductRequest request
    ) {
        return new ApiResponse<>(
                "success",
                "Product updated successfully",
                service.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

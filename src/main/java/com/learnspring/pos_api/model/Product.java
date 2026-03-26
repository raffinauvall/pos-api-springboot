package com.learnspring.pos_api.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nama is required.")
    private String name;

    @NotBlank(message = "Price is Required")
    @Min(value = 0, message = "Price must be >= 0")
    private Integer price;

    @NotBlank(message = "Stock is required")
    @Min(value = 0, message = "Stock must be >= 0")
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}



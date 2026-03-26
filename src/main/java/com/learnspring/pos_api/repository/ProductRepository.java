package com.learnspring.pos_api.repository;

import com.learnspring.pos_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

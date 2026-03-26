package com.learnspring.pos_api.repository;

import com.learnspring.pos_api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {

}

package com.learnspring.pos_api.repository;

import com.learnspring.pos_api.model.TransactionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionItemRepository extends JpaRepository<TransactionItem, Long> {
}

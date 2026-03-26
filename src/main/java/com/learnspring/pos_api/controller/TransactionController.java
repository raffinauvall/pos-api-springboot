package com.learnspring.pos_api.controller;

import com.learnspring.pos_api.dto.ApiResponse;
import com.learnspring.pos_api.dto.TransactionRequest;
import com.learnspring.pos_api.model.Transaction;
import com.learnspring.pos_api.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;

    @PostMapping
    public ApiResponse<Transaction> create(@RequestBody TransactionRequest request) {
        Transaction trx = service.createTransaction(request);
        return new ApiResponse<>("Success", "Transaction Success", trx);
    }

    @GetMapping
    public ApiResponse<List<Transaction>> getAll() {
        return new ApiResponse<>("success", "Successfully get transaction", service.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Transaction> getById(@PathVariable Long id) {
        return new ApiResponse<>("success", "Successfully get transaction", service.getById(id));
    }
}

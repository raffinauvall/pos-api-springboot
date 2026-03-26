package com.learnspring.pos_api.controller;

import com.learnspring.pos_api.dto.ApiResponse;
import com.learnspring.pos_api.dto.TransactionRequest;
import com.learnspring.pos_api.model.Transaction;
import com.learnspring.pos_api.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

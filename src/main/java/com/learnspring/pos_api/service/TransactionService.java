package com.learnspring.pos_api.service;

import com.learnspring.pos_api.dto.TransactionRequest;
import com.learnspring.pos_api.model.Product;
import com.learnspring.pos_api.model.Transaction;
import com.learnspring.pos_api.model.TransactionItem;
import com.learnspring.pos_api.repository.ProductRepository;
import com.learnspring.pos_api.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepo;
    private final ProductRepository productRepo;

    public Transaction createTransaction(TransactionRequest request) {
        List<TransactionItem> items = new ArrayList<>();
        int total = 0;

        for (TransactionRequest.Item reqItem : request.getItems()) {
            Product product = productRepo.findById(reqItem.getProductId())
            .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getStock() < reqItem.getQty()) {
                throw new RuntimeException("Stock not enough for product: " + product.getName());
            }

            int subtotal = product.getPrice() * reqItem.getQty();
            total += subtotal;

            product.setStock(product.getStock() - reqItem.getQty());
            productRepo.save(product);

            TransactionItem item = new TransactionItem();
            item.setProduct(product);
            item.setQty(reqItem.getQty());
            item.setPrice(product.getPrice());

            items.add(item);
        }
        Transaction transaction = new Transaction();
        transaction.setTotal(total);

        for (TransactionItem item: items) {
            item.setTransaction(transaction);
        }
        transaction.setItems(items);

        return transactionRepo.save(transaction);
    }
}

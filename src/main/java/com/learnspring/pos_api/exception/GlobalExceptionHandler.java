package com.learnspring.pos_api.exception;

import com.learnspring.pos_api.dto.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<Void> handdleRuntime(RuntimeException e) {
        return new ApiResponse<>("Error", e.getMessage(), null);
    }
}

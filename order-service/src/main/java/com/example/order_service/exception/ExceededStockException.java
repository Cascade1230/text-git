package com.example.order_service.exception;

public class ExceededStockException extends RuntimeException{
    public ExceededStockException(String message) {
        super(message);
    }
}

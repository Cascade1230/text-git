package com.example.order_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Configuration
@PropertySource(value = "classpath*:order-error-message.properties")
@Getter
public class OrderErrorMessagePropertySource {
    @Value("${error.message.orderNotFound}")
    private String orderNotFoundMessage;
    
    @Value("${error.message.exceededStock}")
    private String exceededStockMessage;
}

package com.example.product_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Configuration

@PropertySource(value = "classpath*:product-error-message.properties")
@Getter
public class ProductErrorMessagePropertySource {
    @Value("${error.message.productNotFound}")
    private String productNotFoundMessage;
}

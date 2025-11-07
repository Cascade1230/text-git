package com.example.user_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Configuration
@PropertySource(value = "classpath*:user-error-message.properties")
@Getter
public class UserErrorMessagePropertySource {
    @Value("${error.message.userNotFound}")
    private String userNotFoundMessage;
}
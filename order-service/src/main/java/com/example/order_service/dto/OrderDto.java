package com.example.order_service.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OrderDto {
	private int id;
	private int productId;
	private String userId;
	private LocalDate orderedAt;
	private String status;
	private int totalAmount;
}

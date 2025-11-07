package com.example.order_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateOrderDto {
	@JsonIgnore
	private int id;
	
	@NotNull
	@Size(max = 20)
	private String userId;
	
	@NotNull
	@Positive
	private int productId;
	
	@NotNull
	@Positive
	private int totalAmount;
}

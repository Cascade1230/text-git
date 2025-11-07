package com.example.product_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateProductDto {
	@JsonIgnore
	private int id;
	
	@NotNull
	@Size(max = 100)
	private String name;

	private String description;
	
	@NotNull
	@Positive
	private int price;
	
	@NotNull
	@Positive
	private int stock;
}

package com.example.product_service.dto;

import lombok.Data;

@Data
public class ProductDto {
	private int id;
	private String name;
	private String description;
	private int price;
	private int stock;
}

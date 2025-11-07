package com.example.product_service.service;

import java.util.List;

import com.example.product_service.dto.CreateProductDto;
import com.example.product_service.dto.ProductDto;
import com.example.product_service.dto.UpdateProductDto;

public interface ProductService {
	List<ProductDto> getAllProducts();
	ProductDto getProduct(int id);
	void createProduct(CreateProductDto createProductDto);
	void updateProduct(int id, UpdateProductDto updateProductDto);
	void deleteProduct(int id);
	void updateStock(int id, int stock);
}

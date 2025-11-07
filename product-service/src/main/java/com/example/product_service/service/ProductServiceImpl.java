package com.example.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product_service.config.ProductErrorMessagePropertySource;
import com.example.product_service.dto.CreateProductDto;
import com.example.product_service.dto.ProductDto;
import com.example.product_service.dto.UpdateProductDto;
import com.example.product_service.exception.ProductNotFoundException;
import com.example.product_service.repository.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductMapper productMapper;
	private final ProductErrorMessagePropertySource productErrorMessagePropertySource;

	@Override
	public List<ProductDto> getAllProducts() {
		return productMapper.findAllProducts();
	}

	@Override
	public ProductDto getProduct(int id) {
		ProductDto product = productMapper.findProductById(id);
		if(product == null) {
			throw new ProductNotFoundException(productErrorMessagePropertySource.getProductNotFoundMessage());
		}
		return product;
	}

	@Override
	public void createProduct(CreateProductDto createProductDto) {
		productMapper.saveProduct(createProductDto);
	}

	@Override
	public void updateProduct(int id, UpdateProductDto updateProductDto) {
		ProductDto product = getProduct(id);
		productMapper.updateProduct(product.getId(), updateProductDto);
	}
	
	@Override
	public void deleteProduct(int id) {
		ProductDto product = getProduct(id);
		productMapper.deleteProductById(product.getId());
	}
	
	@Override
	public void updateStock(int id, int stock) {
		ProductDto product = getProduct(id);
		productMapper.updateStock(product.getId(), stock);
	}
}

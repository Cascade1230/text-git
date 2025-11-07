package com.example.product_service.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.product_service.dto.CreateProductDto;
import com.example.product_service.dto.ProductDto;
import com.example.product_service.dto.UpdateProductDto;

@Mapper
public interface ProductMapper {
	List<ProductDto> findAllProducts();
	ProductDto findProductById(int id);
	void saveProduct(CreateProductDto createProductDto);
	void updateProduct(@Param("id") int id, @Param("updateProductDto") UpdateProductDto updateProductDto);	
	void deleteProductById(int id);
	void updateStock(@Param("id") int id, @Param("stock") int stock);
}

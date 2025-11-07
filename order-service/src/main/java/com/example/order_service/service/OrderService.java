package com.example.order_service.service;

import java.util.List;

import com.example.order_service.dto.CreateOrderDto;
import com.example.order_service.dto.OrderDto;

public interface OrderService {
	List<OrderDto> getUserOrders(String userId);
	OrderDto getOrder(int id);	
	void createOrder(CreateOrderDto createOrderDto);
	void deleteOrder(int id);
}

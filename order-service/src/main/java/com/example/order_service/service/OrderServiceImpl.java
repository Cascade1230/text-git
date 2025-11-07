package com.example.order_service.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.order_service.config.OrderErrorMessagePropertySource;
import com.example.order_service.dto.CreateOrderDto;
import com.example.order_service.dto.OrderDto;
import com.example.order_service.exception.ExceededStockException;
import com.example.order_service.exception.OrderNotFoundException;
import com.example.order_service.repository.OrderMapper;
import com.example.product_service.dto.ProductDto;
import com.example.product_service.service.ProductService;
import com.example.user_service.dto.UserDto;
import com.example.user_service.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	private final OrderMapper orderMapper;
	private final ProductService productService;
	private final UserService userService;
	private final OrderErrorMessagePropertySource orderErrorMessagePropertySource;

	@Override
	public List<OrderDto> getUserOrders(String userId) {
		return orderMapper.findUserOrders(userId);
	}

	@Override
	public OrderDto getOrder(int id) {
		OrderDto order = orderMapper.findOrderById(id);
		if (order == null) {
			throw new OrderNotFoundException(orderErrorMessagePropertySource.getOrderNotFoundMessage());
		}
		return order;
	}

	@Override
	@Transactional
	public void createOrder(CreateOrderDto createOrderDto) {
		UserDto _user = userService.getUser(createOrderDto.getUserId());
		ProductDto product = productService.getProduct(createOrderDto.getProductId());

		int stock = product.getStock() - createOrderDto.getTotalAmount();
		if (stock < 0) { // 재고 확인
			throw new ExceededStockException(orderErrorMessagePropertySource.getExceededStockMessage());
		}

		productService.updateStock(product.getId(), stock);
		orderMapper.saveOrder(createOrderDto);
	}

	@Override
	@Transactional
	public void deleteOrder(int id) {
    	OrderDto order = getOrder(id);
    	ProductDto product = productService.getProduct(order.getProductId());
        int stock = product.getStock() + order.getTotalAmount();
        productService.updateStock(order.getProductId(), stock);
        orderMapper.deleteOrderById(id);
	}
}

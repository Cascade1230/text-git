package com.example.api_service.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.order_service.dto.CreateOrderDto;
import com.example.order_service.dto.OrderDto;
import com.example.order_service.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;

	// 사용자의 모든 주문 목록
	@GetMapping("/orders/user-orders/{userId}")
	public ResponseEntity<List<OrderDto>> getUserOrders(@PathVariable("userId") String userId) {
		return ResponseEntity.ok(orderService.getUserOrders(userId));
	}

	// 주문 상세
	@GetMapping("/orders/{id}")
	public ResponseEntity<OrderDto> getOrder(@PathVariable("id") int id) {
		return ResponseEntity.ok(orderService.getOrder(id));
	}

	// 주문
	@PostMapping("/orders")
	public ResponseEntity<Void> createOrder(@RequestBody @Valid CreateOrderDto createOrderDto) {
		orderService.createOrder(createOrderDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createOrderDto.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	// 주문 취소
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<OrderDto> deleteOrder(@PathVariable("id") int id) {
		orderService.deleteOrder(id);
		String too = "hello";
		return ResponseEntity.ok().build();
	}
}

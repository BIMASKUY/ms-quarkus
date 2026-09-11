package com.mpkmb.service;

import com.mpkmb.dto.request.CreateOrderRequest;
import com.mpkmb.dto.response.OrderResponse;
import com.mpkmb.entity.Order;
import com.mpkmb.repository.OrderRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class OrderService {
  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Transactional
  public OrderResponse createOrder(CreateOrderRequest request) {
    Order order = new Order(request.quantity(), request.productId());
    orderRepository.persist(order);
    return new OrderResponse(order.getQuantity(), order.getProductId());
  }

  public List<OrderResponse> getOrders() {
    List<Order> orders = orderRepository.listAll();
    return orders.stream()
      .map(order -> new OrderResponse(order.getQuantity(), order.getProductId()))
      .toList();
  }
}

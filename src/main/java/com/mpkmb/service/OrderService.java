package com.mpkmb.service;

import com.mpkmb.dto.request.CreateOrderRequest;
import com.mpkmb.dto.response.OrderResponse;
import com.mpkmb.entity.Order;
import com.mpkmb.entity.Product;
import com.mpkmb.repository.OrderRepository;
import com.mpkmb.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class OrderService {
  private final OrderRepository orderRepository;
  private final ProductRepository productRepository;

  public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
  }

  @Transactional
  public OrderResponse createOrder(CreateOrderRequest request) {
    Product product = productRepository.findById(request.productId());
    if (product == null) {
      throw new IllegalArgumentException("Product not found");
    }

    Order order = new Order(request.quantity(), product);
    orderRepository.persist(order);
    return new OrderResponse(product.getName(), product.getPrice(), order.getQuantity());
  }

  public List<OrderResponse> getOrders() {
    List<Order> orders = orderRepository.listAll();
    return orders.stream()
      .map(order -> new OrderResponse(
        order.getProduct().getName(),
        order.getProduct().getPrice(),
        order.getQuantity()
      ))
      .toList();
  }
}

package com.mpkmb.controller;

import com.mpkmb.dto.request.CreateOrderRequest;
import com.mpkmb.dto.response.OrderResponse;
import com.mpkmb.service.OrderService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderController {
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GET()
  public List<OrderResponse> getOrders() {
    return orderService.getOrders();
  }

  @POST()
  public OrderResponse createOrder(CreateOrderRequest request) {
    return orderService.createOrder(request);
  }
}

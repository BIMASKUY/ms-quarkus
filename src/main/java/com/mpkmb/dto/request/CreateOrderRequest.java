package com.mpkmb.dto.request;

public record CreateOrderRequest(
  Long quantity,
  Long productId
) {
}

package com.mpkmb.dto.response;

public record OrderResponse(
  String name,
  Long price,
  Long quantity
) {
}

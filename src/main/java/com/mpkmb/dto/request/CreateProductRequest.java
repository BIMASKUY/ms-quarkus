package com.mpkmb.dto.request;

public record CreateProductRequest(
  String name,
  Long price
) {
}

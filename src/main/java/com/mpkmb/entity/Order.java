package com.mpkmb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="orders")
public class Order {
  @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(nullable=false)
  @Min(1)
  private Long quantity;

  @Column(nullable=false)
  private Long productId;

  protected Order() {}

  public Order(Long quantity, Long productId) {
    this.quantity = quantity;
    this.productId = productId;
  }

  public Long getQuantity() {
    return quantity;
  }

  public Long getProductId() {
    return productId;
  }
}

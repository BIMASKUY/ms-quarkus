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

  @ManyToOne(
    fetch = FetchType.LAZY,
    optional = false
  )
  @JoinColumn(
    name = "product_id",
    referencedColumnName = "id",
    nullable = false
  )
  Product product;

  protected Order() {}

  public Order(Long quantity, Product product) {
    this.quantity = quantity;
    this.product = product;
  }

  public Long getQuantity() {
    return quantity;
  }

  public Product getProduct() {
    return product;
  }
}

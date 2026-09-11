package com.mpkmb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(nullable=false)
  private String name;

  @Column(nullable=false)
  @Min(1)
  private Long price;

  public Product(String name, Long price) {
    this.name = name;
    this.price = price;
  }

  protected Product() {}

  public String getName() {
    return name;
  }

  public Long getPrice() {
    return price;
  }
}

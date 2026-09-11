package com.mpkmb.service;

import com.mpkmb.dto.request.CreateProductRequest;
import com.mpkmb.dto.response.ProductResponse;
import com.mpkmb.entity.Product;
import com.mpkmb.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<ProductResponse> getProducts() {
    List<Product> products = productRepository.listAll();
    return products.stream()
      .map(product -> new ProductResponse(product.getName(), product.getPrice()))
      .toList();
  }

  @Transactional
  public ProductResponse createProduct(CreateProductRequest request) {
    Product product = new Product(request.name(), request.price());
    productRepository.persist(product);
    return new ProductResponse(product.getName(), product.getPrice());
  }
}

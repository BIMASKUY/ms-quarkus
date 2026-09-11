package com.mpkmb.controller;

import com.mpkmb.dto.request.CreateProductRequest;
import com.mpkmb.dto.response.ProductResponse;
import com.mpkmb.service.ProductService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("/products")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GET()
  @Produces("application/json")
  public List<ProductResponse> getProducts() {
    return productService.getProducts();
  }

  @POST()
  @Produces("application/json")
  public ProductResponse createProduct(CreateProductRequest request) {
    return productService.createProduct(request);
  }
}

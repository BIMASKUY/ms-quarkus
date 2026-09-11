package com.mpkmb.controller;

import com.mpkmb.dto.request.CreateProductRequest;
import com.mpkmb.dto.response.ProductResponse;
import com.mpkmb.service.ProductService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GET()
  public List<ProductResponse> getProducts() {
    return productService.getProducts();
  }

  @POST()
  public ProductResponse createProduct(CreateProductRequest request) {
    return productService.createProduct(request);
  }
}

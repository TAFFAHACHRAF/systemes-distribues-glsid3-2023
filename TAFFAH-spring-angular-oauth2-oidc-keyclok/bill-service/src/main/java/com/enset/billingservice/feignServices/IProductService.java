package com.enset.billingservice.feignServices;

import com.enset.billingservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service", url = "http://localhost:8098")
public interface IProductService {
    @GetMapping("/products/{productId}")
    Product findProductById(@PathVariable Long productId);

    @GetMapping("/products")
    PagedModel<Product> findAll();
}

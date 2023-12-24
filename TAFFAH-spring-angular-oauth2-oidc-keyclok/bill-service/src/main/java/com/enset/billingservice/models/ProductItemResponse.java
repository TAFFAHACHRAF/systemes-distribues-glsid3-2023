package com.enset.billingservice.models;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductItemResponse {
    private Long id;
    private Long productID;
    private Double price;
    private Double quantity;
    private Product product;
    private Customer customer;
}

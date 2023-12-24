package com.enset.billingservice.models;

import com.enset.billingservice.entities.ProductItem;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BillResponse {
    private Long id;
    private Date billingDate;
    private Collection<ProductItemResponse> productItems;
    private long customerID;
    private Customer customer;
}

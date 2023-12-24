package com.enset.billingservice.repositories;

import com.enset.billingservice.entities.ProductItem;
import com.enset.billingservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
    List<ProductItem> findByBillId(Long billID);
}

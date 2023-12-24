package com.enset.billingservice.controllers;

import com.enset.billingservice.entities.Bill;
//import com.enset.billingservice.feignServices.ICustomerService;
import com.enset.billingservice.entities.ProductItem;
import com.enset.billingservice.feignServices.ICustomerService;
import com.enset.billingservice.feignServices.IProductService;
import com.enset.billingservice.models.BillResponse;
import com.enset.billingservice.models.ProductItemResponse;
import com.enset.billingservice.repositories.BillRepository;
import com.enset.billingservice.repositories.ProductItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BillController {
    private final BillRepository billRepository;
    private final ProductItemRepository productItemRepository;
    private final IProductService inventoryServiceClient;
    private final ICustomerService customerService;

    @GetMapping("/bills/full/{id}")
    public BillResponse getBill(@PathVariable(name = "id") Long id) {
        Bill bill = billRepository.findById(id).orElse(null);

        if (bill == null) {
            // Handle the case where the bill is not found
            return null; // or throw an exception or return an appropriate response
        }

        bill.setProductItems(productItemRepository.findByBillId(id));
        bill.setCustomer(customerService.findCustomerById(bill.getCustomerID()));
        bill.getProductItems().forEach(pi -> {
            pi.setProduct(inventoryServiceClient.findProductById(pi.getProductID()));
        });

        BillResponse billResponse = new BillResponse();
        billResponse.setCustomerID(bill.getCustomerID());
        billResponse.setBillingDate(bill.getBillingDate());
        billResponse.setId(bill.getId());
        billResponse.setCustomer(bill.getCustomer());

        // Map ProductItem to ProductItemResponse
        Collection<ProductItemResponse> productItemResponses = bill.getProductItems()
                .stream()
                .map(this::mapProductItemToResponse)
                .collect(Collectors.toList());

        billResponse.setProductItems(productItemResponses);

        return billResponse;
    }

    private ProductItemResponse mapProductItemToResponse(ProductItem productItem) {
        return ProductItemResponse.builder()
                .id(productItem.getId())
                .productID(productItem.getProductID())
                .price(productItem.getPrice())
                .quantity(productItem.getQuantity())
                .product(productItem.getProduct())
                .build();
    }

}

package com.enset.billingservice;

import com.enset.billingservice.entities.Bill;
import com.enset.billingservice.entities.ProductItem;
//import com.enset.billingservice.feignServices.ICustomerService;
import com.enset.billingservice.feignServices.IProductService;
import com.enset.billingservice.models.Customer;
import com.enset.billingservice.repositories.BillRepository;
import com.enset.billingservice.repositories.ProductItemRepository;
import org.apache.el.parser.AstListData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository,
                            IProductService inventoryServiceClient/*, ICustomerService customerServiceClient*/){

        return args -> {

            Bill bill=new Bill();
            bill.setBillingDate(new Date());
            bill.setCustomerID(2L);
            billRepository.save(bill);

            ProductItem productItem=new ProductItem();
            productItem.setProductID(1L);
            productItem.setQuantity(7845.2);
            productItem.setPrice(8745.4);
            productItem.setBill(bill);
            productItemRepository.save(productItem);

            ProductItem productItem2=new ProductItem();
            productItem2.setProductID(2L);
            productItem2.setQuantity(7845.2);
            productItem2.setPrice(8745.4);
            productItem2.setBill(bill);
            productItemRepository.save(productItem2);

            System.out.println("ID : "+bill.getId());
        };

    }
}

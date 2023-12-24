package com.enset.billingservice.feignServices;

import com.enset.billingservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="customer-service",url="http://localhost:8090")
public interface ICustomerService {
    @GetMapping("/cc/{id}")
    Customer findCustomerById(@PathVariable("id") Long id);
}

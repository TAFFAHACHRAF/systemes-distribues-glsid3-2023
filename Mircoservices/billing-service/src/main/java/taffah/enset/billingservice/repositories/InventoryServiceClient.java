package taffah.enset.billingservice.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import taffah.enset.billingservice.entities.Product;

@FeignClient(name="inventory-service")
@Service
public interface InventoryServiceClient{
    @GetMapping("/products/{id}?projection=fullProduct")
    Product findProductById(@PathVariable("id") String id);
    @GetMapping("/products?projection=fullProduct")
    PagedModel<Product> findAll();
}

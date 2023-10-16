package taffah.enset.billingservice.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import taffah.enset.billingservice.entities.Bill;
import taffah.enset.billingservice.repositories.BillRepository;
import taffah.enset.billingservice.repositories.CustomerServiceClient;
import taffah.enset.billingservice.repositories.InventoryServiceClient;
import taffah.enset.billingservice.repositories.ProductRepository;

@RestController
class BillRestController{
    private BillRepository billRepository;
    private ProductRepository productItemRepository;
    private CustomerServiceClient customerServiceClient;
    InventoryServiceClient inventoryServiceClient;
    @GetMapping("/bills/full/{id}")
    Bill getBill(@PathVariable(name="id") Long id){
        Bill bill=billRepository.findById(id).get();
        bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerID()));
        bill.setProductItems(productItemRepository.findByBillId(id));
        /*bill.getProductItems().forEach(pi->{
            pi.setProduct(inventoryServiceClient.findProductById(pi.getProductID()));
        });*/
        return bill; }
}

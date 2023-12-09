package taffah.enset.customerfrontthymleafapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import taffah.enset.customerfrontthymleafapp.entities.Customer;
import taffah.enset.customerfrontthymleafapp.repository.CustomerRepository;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerRepository customerRepository;
    public  CustomerController(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @GetMapping("/customers")
    public Model getCustomers(Model model){
        List<Customer> customers=customerRepository.findAll();
        model.addAttribute("customers",customers);
        return model;
    }
}

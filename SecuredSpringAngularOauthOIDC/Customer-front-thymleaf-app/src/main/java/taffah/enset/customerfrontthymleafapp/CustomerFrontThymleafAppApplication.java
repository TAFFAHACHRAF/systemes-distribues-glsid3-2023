package taffah.enset.customerfrontthymleafapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import taffah.enset.customerfrontthymleafapp.entities.Customer;
import taffah.enset.customerfrontthymleafapp.repository.CustomerRepository;

@SpringBootApplication
public class CustomerFrontThymleafAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerFrontThymleafAppApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            Customer customer=Customer.builder().name("Achraf").email("achraf@gmail.com").build();
            customerRepository.save(customer);
        };
    }
}

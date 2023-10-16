package taffah.enset.consumerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import taffah.enset.consumerservice.entities.Customer;
import taffah.enset.consumerservice.repositories.CustomerRepository;

import java.util.UUID;


@SpringBootApplication
@EnableEurekaClient
public class ConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args ->{
			customerRepository.save(Customer.builder().id(UUID.randomUUID().toString()).email("taffahachraf184@gmail.com").name("achraf taffah").build());
			customerRepository.save(Customer.builder().id(UUID.randomUUID().toString()).email("anas@gmail.com").name("anas taffah").build());
			customerRepository.save(Customer.builder().id(UUID.randomUUID().toString()).email("salma@gmail.com").name("salma taffah").build());
			customerRepository.save(Customer.builder().id(UUID.randomUUID().toString()).email("mohammed@gmail.com").name("mohammed taffah").build());
		};
	}


}

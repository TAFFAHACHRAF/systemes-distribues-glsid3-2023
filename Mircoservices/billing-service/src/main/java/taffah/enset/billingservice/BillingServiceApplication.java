package taffah.enset.billingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import taffah.enset.billingservice.entities.Bill;
import taffah.enset.billingservice.repositories.BillRepository;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableConfigurationProperties(ConfigParams.class)
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillRepository billRepository){
		return args -> {
			Bill b=Bill.builder().id(UUID.randomUUID().toString()).customerID("16fe6006-ecd7-4515-ac4d-86567d10aa7e").billingDate(new Date()).build();
			System.out.println();
			billRepository.save(b);
		};
	}
}

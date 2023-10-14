package taffah.enset.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import taffah.enset.inventoryservice.entities.Product;
import taffah.enset.inventoryservice.repositories.ProductRepository;


@SpringBootApplication
public class InventoryrServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventoryrServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository inventoryRepository) {
		return args ->{
			inventoryRepository.save(Product.builder().price(987456).name("pc").quantity(987).build());
			inventoryRepository.save(Product.builder().price(987654321).name("tablet").quantity(85).build());
			inventoryRepository.save(Product.builder().price(78456).name("phone").quantity(58).build());
			inventoryRepository.save(Product.builder().price(78451).name("processor").quantity(5).build());
		};
	}


}

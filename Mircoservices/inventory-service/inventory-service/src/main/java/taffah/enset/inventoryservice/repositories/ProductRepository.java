package taffah.enset.inventoryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import taffah.enset.inventoryservice.entities.Product;

@RepositoryRestController
public interface ProductRepository extends JpaRepository<Product,Long> {
}

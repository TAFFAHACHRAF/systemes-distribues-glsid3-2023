package taffah.enset.consumerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import taffah.enset.consumerservice.entities.Customer;

@RepositoryRestController
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

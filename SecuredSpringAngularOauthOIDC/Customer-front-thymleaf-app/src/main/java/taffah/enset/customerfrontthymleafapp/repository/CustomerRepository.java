package taffah.enset.customerfrontthymleafapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taffah.enset.customerfrontthymleafapp.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

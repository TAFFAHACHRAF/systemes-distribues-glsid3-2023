package taffah.enset.billingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import taffah.enset.billingservice.entities.ProductItem;

import java.util.List;

@RepositoryRestController
public interface ProductRepository extends JpaRepository<ProductItem,Long> {
    List<ProductItem> findByBillId(Long billID);
}

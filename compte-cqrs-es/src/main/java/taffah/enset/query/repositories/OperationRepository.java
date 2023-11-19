package taffah.enset.query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import taffah.enset.query.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}

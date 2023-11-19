package taffah.enset.query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import taffah.enset.query.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
}

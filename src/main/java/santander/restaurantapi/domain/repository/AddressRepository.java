package santander.restaurantapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import santander.restaurantapi.domain.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}

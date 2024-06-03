package santander.restaurantapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import santander.restaurantapi.domain.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

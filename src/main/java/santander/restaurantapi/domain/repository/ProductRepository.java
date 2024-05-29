package santander.restaurantapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import santander.restaurantapi.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

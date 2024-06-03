package santander.restaurantapi.domain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "products")
@Getter
@Setter
public class Product extends BaseEntity implements Serializable {
    private BigDecimal price;
    private String category;
    private String description;
}

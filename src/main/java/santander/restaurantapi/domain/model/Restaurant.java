package santander.restaurantapi.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity(name = "restaurants")
@Getter
@Setter
public class Restaurant extends BaseEntity implements Serializable {
    @Lob
    private Address address;
    private List<String> operatingDays;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products;
}

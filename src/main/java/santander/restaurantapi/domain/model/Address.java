package santander.restaurantapi.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity(name = "address")
@Getter
@Setter
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String city;
    private String state;
    private String neighborhood;
    private String street;
    private String number;
}

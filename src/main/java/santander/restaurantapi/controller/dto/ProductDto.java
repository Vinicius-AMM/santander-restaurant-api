package santander.restaurantapi.controller.dto;

import java.math.BigDecimal;

public record ProductDto(Long id, String name, String urlPicture, BigDecimal price, String category, String description) {

}

package santander.restaurantapi.controller.dto;

import santander.restaurantapi.domain.model.Product;

import java.math.BigDecimal;

public record ProductDto(Long id, String name, String urlPicture, BigDecimal price, String category, String description) {
    public ProductDto(Product model){
        this(model.getId(),
                model.getName(),
                model.getUrlPicture(),
                model.getPrice(),
                model.getCategory(),
                model.getDescription());
    }

    public Product toModel(){
        Product model = new Product();
        model.setId(id);
        model.setName(name);
        model.setName(name);
        model.setUrlPicture(urlPicture);
        model.setPrice(price);
        model.setCategory(category);
        model.setDescription(description);
        return model;
    }
}

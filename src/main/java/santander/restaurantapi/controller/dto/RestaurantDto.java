package santander.restaurantapi.controller.dto;

import santander.restaurantapi.domain.model.Address;
import santander.restaurantapi.domain.model.Product;
import santander.restaurantapi.domain.model.Restaurant;

import java.util.List;

public record RestaurantDto(Long id, String name, String urlPicture, Address address, List<String> operatingDays, List<Product> products) {
    public RestaurantDto(Restaurant model){
        this(model.getId(),
                model.getName(),
                model.getUrlPicture(),
                model.getAddress(),
                model.getOperatingDays(),
                model.getProducts());
    }


    public Restaurant toModel(){
        Restaurant model = new Restaurant();
        model.setName(name);
        model.setUrlPicture(urlPicture);
        model.setAddress(address);
        model.setOperatingDays(operatingDays);
        model.setProducts(products);
        return model;
    }



}

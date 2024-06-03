package santander.restaurantapi.controller.dto;

import santander.restaurantapi.domain.model.Address;

public record AddressDto(Long id, String cep, String city, String state, String neighborhood, String street, String number) {
    public AddressDto(Address model){
        this(model.getId(),
                model.getCep(),
                model.getCity(),
                model.getState(),
                model.getNeighborhood(),
                model.getStreet(),
                model.getNumber());
    }

    public Address toModel(){
        Address model = new Address();
        model.setId(id);
        model.setCep(cep);
        model.setCity(city);
        model.setState(state);
        model.setNeighborhood(neighborhood);
        model.setStreet(street);
        model.setNumber(number);
        return model;
    }

}

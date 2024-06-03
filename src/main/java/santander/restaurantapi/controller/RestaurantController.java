package santander.restaurantapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import santander.restaurantapi.controller.dto.RestaurantDto;
import santander.restaurantapi.domain.model.Restaurant;
import santander.restaurantapi.service.RestaurantService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> findAll(){
        List<Restaurant> restaurants = (List<Restaurant>) restaurantService.findAll();
        List<RestaurantDto> restaurantDtos = restaurants.stream().map(RestaurantDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(restaurantDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> findById(@PathVariable Long id){
        Restaurant restaurant = restaurantService.findById(id);
        return ResponseEntity.ok(new RestaurantDto(restaurant));
    }
    @PostMapping
    public ResponseEntity<RestaurantDto> create(@RequestBody RestaurantDto restaurantToCreate){
        Restaurant restaurant = restaurantService.create(restaurantToCreate.toModel());
        return ResponseEntity.ok(new RestaurantDto(restaurant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto> update(@PathVariable Long id, @RequestBody RestaurantDto restaurantDto){
        var restaurant = restaurantService.update(id, restaurantDto.toModel());
        return ResponseEntity.ok(new RestaurantDto(restaurant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        restaurantService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

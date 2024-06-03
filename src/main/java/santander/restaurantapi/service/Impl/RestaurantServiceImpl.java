package santander.restaurantapi.service.Impl;

import org.springframework.stereotype.Service;
import santander.restaurantapi.domain.model.Restaurant;
import santander.restaurantapi.domain.repository.RestaurantRepository;
import santander.restaurantapi.service.RestaurantService;
import santander.restaurantapi.service.exception.BusinessException;
import santander.restaurantapi.service.exception.NotFoundException;

import static java.util.Optional.ofNullable;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private static final Long UNCHANGEABLE_RESTAURANT_ID = 1L;
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public Iterable<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Restaurant create(Restaurant restaurantToCreate) {
        ofNullable(restaurantToCreate).orElseThrow(() -> new BusinessException("Restaurant to create must not be null!"));
        if(restaurantRepository.existsById(restaurantToCreate.getId())){
            throw new BusinessException("Restaurant already exists!");
        }
        return restaurantRepository.save(restaurantToCreate);
    }

    @Override
    public Restaurant update(Long id, Restaurant restaurantToUpdate) {
        validateChangeableId(id, "updated");
        Restaurant dbRestaurant = this.findById(id);
        if(!dbRestaurant.getId().equals(restaurantToUpdate.getId())){
            throw new BusinessException("Update IDs must be the same!");
        }
        dbRestaurant.setName(restaurantToUpdate.getName());
        dbRestaurant.setUrlPicture(restaurantToUpdate.getUrlPicture());
        dbRestaurant.setAddress(restaurantToUpdate.getAddress());
        dbRestaurant.setOperatingDays(restaurantToUpdate.getOperatingDays());
        dbRestaurant.setProducts(restaurantToUpdate.getProducts());

        return restaurantRepository.save(dbRestaurant);
    }

    @Override
    public void deleteById(Long id) {
        this.validateChangeableId(id, "deleted");
        restaurantRepository.deleteById(id);
    }
    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_RESTAURANT_ID.equals(id)) {
            throw new BusinessException("User with ID %d can not be %s.".formatted(UNCHANGEABLE_RESTAURANT_ID, operation));
        }
    }
}

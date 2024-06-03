package santander.restaurantapi.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import santander.restaurantapi.domain.repository.RestaurantRepository;
import santander.restaurantapi.service.Impl.RestaurantServiceImpl;

@Configuration
public class RestaurantServiceConfig {
    @Bean
    public RestaurantServiceImpl restaurantService(RestaurantRepository restaurantRepository){
        return new RestaurantServiceImpl(restaurantRepository);
    }
}

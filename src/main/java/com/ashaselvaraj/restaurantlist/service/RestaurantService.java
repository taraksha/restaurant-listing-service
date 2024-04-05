package com.ashaselvaraj.restaurantlist.service;

import com.ashaselvaraj.restaurantlist.dto.RestaurantDTO;
import com.ashaselvaraj.restaurantlist.entity.Restaurant;
import com.ashaselvaraj.restaurantlist.entity.mapper.RestaurantMapper;
import com.ashaselvaraj.restaurantlist.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RestaurantService {
    RestaurantRepo restaurantRepo;
    @Autowired
    public void setRestaurantRepo(RestaurantRepo restaurantRepo){
        this.restaurantRepo=restaurantRepo;
    }

    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();

        return restaurants.stream()
             // .peek(restaurant -> System.out.println("NAme**************** "+restaurant.getName()))
                          .map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO)
                          .toList();
    }

    public RestaurantDTO addNewRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant savedRestaurant = restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);
    }


    public ResponseEntity<RestaurantDTO>  findRestaurantById(Integer id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if(restaurant.isPresent()) {
            return  new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()) , HttpStatus.OK);
        }
        return  new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
    }
}


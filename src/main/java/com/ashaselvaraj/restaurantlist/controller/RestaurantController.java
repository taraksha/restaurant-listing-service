package com.ashaselvaraj.restaurantlist.controller;

import com.ashaselvaraj.restaurantlist.dto.RestaurantDTO;
import com.ashaselvaraj.restaurantlist.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

    RestaurantService restaurantService;
    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService=restaurantService;
    }


    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants(){
        List<RestaurantDTO> allRestaurantsDTO = restaurantService.findAllRestaurants();
    return new ResponseEntity<>(allRestaurantsDTO, HttpStatus.OK);
    }

    @PostMapping("addRestaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO restaurantDTOAdd = restaurantService.addNewRestaurant(restaurantDTO);
        return new ResponseEntity<>(restaurantDTOAdd,HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantById/{id}")
    public ResponseEntity<RestaurantDTO> fetchRestaurantById(@PathVariable Integer id){
        return restaurantService.findRestaurantById(id);
    }
}

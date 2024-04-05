package com.ashaselvaraj.restaurantlist.repo;

import com.ashaselvaraj.restaurantlist.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {
}

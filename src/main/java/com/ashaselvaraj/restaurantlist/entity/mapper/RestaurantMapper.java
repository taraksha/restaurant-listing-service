package com.ashaselvaraj.restaurantlist.entity.mapper;

import com.ashaselvaraj.restaurantlist.dto.RestaurantDTO;
import com.ashaselvaraj.restaurantlist.entity.Restaurant;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")

public interface RestaurantMapper {

    RestaurantMapper  INSTANCE = Mappers.getMapper(RestaurantMapper.class);
    @Mapping(source = "name", target = "name")
    Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
}

package com.ji.review.service;

import com.ji.review.api.request.CreateAndEditRestaurantRequest;
import com.ji.review.model.MenuEntity;
import com.ji.review.model.RestaurantEntity;
import com.ji.review.repository.MenuRepository;
import com.ji.review.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    @Transactional
    public RestaurantEntity createRestaurant(
            CreateAndEditRestaurantRequest request
    ) {
        RestaurantEntity restaurant = RestaurantEntity.builder()
                .name(request.getName())
                .address(request.getAddress())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();
        restaurantRepository.save(restaurant);

        request.getMenus().forEach((menu) -> {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurant.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createdAt(ZonedDateTime.now())
                    .updatedAt(ZonedDateTime.now())
                    .build();
            menuRepository.save(menuEntity);
        });

        return  restaurant;
    }

    @Transactional
    public void editRestaurant() {
    }

    @Transactional
    public void deleteRestaurant() {
    }
}
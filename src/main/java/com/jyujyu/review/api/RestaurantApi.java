package com.jyujyu.review.api;

import com.jyujyu.review.api.request.CreateAndEditRestaurantRequest;
import com.jyujyu.review.api.response.RestaurantDetailView;
import com.jyujyu.review.api.response.RestaurantView;
import com.jyujyu.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailView getRestaurant(
            @PathVariable(name = "restaurantId") Long restaurantId
    ) {
        return restaurantService.getRestaurantDetail(restaurantId);
    }

    @PostMapping("/restaurant")
    public void createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        restaurantService.createRestaurant(request);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(
            @PathVariable(name = "restaurantId") Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        restaurantService.editRestaurant(restaurantId, request);
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaurant(
            @PathVariable(name = "restaurantId") Long restaurantId
    ) {
        restaurantService.deleteRestaurant(restaurantId);
    }
}

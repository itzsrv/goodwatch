package com.goodwatch.ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodwatch.ratingsdataservice.models.Rating;
import com.goodwatch.ratingsdataservice.models.UserRating;

@RestController
@RequestMapping("/api/ratingdata")
public class RatingResource {
    
    @RequestMapping("/users/{userId}")
    public UserRating getUserMovieRating(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(
            new Rating("1234", 5),
            new Rating("3456", 3)
        );
        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);
        return userRating;
    }
}

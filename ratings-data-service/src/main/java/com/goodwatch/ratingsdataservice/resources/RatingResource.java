package com.goodwatch.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodwatch.ratingsdataservice.models.Rating;

@RestController
@RequestMapping("/api/ratingdata")
public class RatingResource {
    
    @RequestMapping("/{userId}")
    public Rating getMovieRating(@PathVariable("userId") String userId){
        return new Rating(userId, 5);
    }
}

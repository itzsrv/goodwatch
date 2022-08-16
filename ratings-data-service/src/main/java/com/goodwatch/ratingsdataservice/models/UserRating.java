package com.goodwatch.ratingsdataservice.models;

import java.util.List;

public class UserRating {
    private List<Rating> ratings;
    

    public UserRating(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public UserRating() {
    }


    public List<Rating> getRatings() {
        return this.ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

}
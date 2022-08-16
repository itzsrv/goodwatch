package com.goodwatch.moviecatalogservice.models;

public class Rating {
    
    private String movieId;
    private int movieRating;


    public Rating(String movieId, int movieRating) {
        this.movieId = movieId;
        this.movieRating = movieRating;
    }

    public String getMovieId() {
        return this.movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getMovieRating() {
        return this.movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

}

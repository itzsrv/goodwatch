package com.goodwatch.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodwatch.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/api/movies")
public class MovieInfoResource{

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        return new Movie(movieId, "kuch kuch hota hai", "romantic");
    }
}
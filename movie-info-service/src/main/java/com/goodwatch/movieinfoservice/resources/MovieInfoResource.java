package com.goodwatch.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodwatch.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/api/movies")
public class MovieInfoResource{

    @RequestMapping("/{userId}")
    public Movie getMovieInfo(@PathVariable("userId") String userId){
        return new Movie("11", "kuch kuch hota hai", "romantic");
    }
}
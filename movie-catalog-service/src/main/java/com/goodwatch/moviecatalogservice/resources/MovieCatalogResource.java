package com.goodwatch.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.goodwatch.moviecatalogservice.models.CatalogItem;
import com.goodwatch.moviecatalogservice.models.Movie;
import com.goodwatch.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/api/catalog")
public class MovieCatalogResource{

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        

        RestTemplate restTemplate = new RestTemplate();
        
        //get all rated movieIds - hardcode
        List<Rating> ratings = Arrays.asList(
            new Rating("1234",3),
            new Rating("3456", 4)
        );

        //for each movieId, call movieInfo service and get movieInfo
        return ratings.stream().map(rating-> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/api/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getMovieName(), movie.getMovieDesc(), rating.getMovieRating());
        })
        .collect(Collectors.toList());

        //put them all together


        // return Collections.singletonList(
        //     new CatalogItem("transformers", "animated", 4)
        // );
    }
}
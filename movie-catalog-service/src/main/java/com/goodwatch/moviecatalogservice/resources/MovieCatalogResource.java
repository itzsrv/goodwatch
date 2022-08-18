package com.goodwatch.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.goodwatch.moviecatalogservice.models.CatalogItem;
import com.goodwatch.moviecatalogservice.models.Movie;
import com.goodwatch.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/api/catalog")
public class MovieCatalogResource{

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        

        //get all rated movieIds - hardcode
        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/api/ratingdata/users/" + userId, UserRating.class);

        return ratings.getRatings().stream().map(rating-> {
           
            //for each movieId, call movieInfo service and get movieInfo  
            Movie movie = restTemplate.getForObject("http://movie-info-service/api/movies/" + rating.getMovieId(), Movie.class);
    
    
            //put them all together
            return new CatalogItem(movie.getMovieName(), movie.getMovieDesc(), rating.getMovieRating());
        })
        .collect(Collectors.toList());



        // return Collections.singletonList(
        //     new CatalogItem("transformers", "animated", 4)
        // );
    }
}
package com.goodwatch.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodwatch.moviecatalogservice.models.CatalogItem;

@RestController
@RequestMapping("/api/catalog")
public class MovieCatalogResource{

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        

        //get all rated movieIds - hardcode


        //for each movieId, call movieInfo service and get movieInfo


        //put them all together


        return Collections.singletonList(
            new CatalogItem("transformers", "animated", 4)
        );
    }
}
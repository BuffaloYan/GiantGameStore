package com.giantgame.controller;

import com.giantgame.model.CheckoutRequest;
import com.giantgame.model.GameData;
import com.giantgame.model.GiantGameResponse;
import com.giantgame.model.SearchResult;
import com.giantgame.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class GameController {

    @Autowired
    SearchService searchService;

    @GetMapping("/search")
    public SearchResult search(@RequestParam String filter){
        GiantGameResponse gameResponse = searchService.search(filter);

        SearchResult result = new SearchResult();
        result.setError("Ok");
        result.setResults(Arrays.stream(gameResponse.getResults())
                .map( giantGame -> {
                    GameData data = new GameData();
                    data.setId(giantGame.getId());
                    data.setName(giantGame.getName());
                    data.setDescription(giantGame.getDeck());
                    data.setThumbnail(giantGame.getImage().getThumb_url());

                    return data;
                }).collect(Collectors.toList()).toArray(new GameData[0])
            );

        return result;
    }

    @PostMapping("/checkout")
    public SearchResult checkout(@RequestBody CheckoutRequest request){
        SearchResult result = new SearchResult();
        result.setError("Ok");
        return result;
    }

}

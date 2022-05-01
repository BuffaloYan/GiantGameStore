package com.giantgame.service;

import com.giantgame.model.GiantGameResponse;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;

@Service
public class SearchService {
    public static final String GIANT_GAME_URL = "https://www.giantbomb.com/api/search/?api_key=588e3a11661e408a4f4dd845d9d0ffae7dc6161b&format=json&query=%s&resources=game&field_list=id,name,deck,image";

    private RestTemplate restTemplate = new RestTemplate();

    public GiantGameResponse search(String searchStr) {
        String url = String.format(GIANT_GAME_URL, URLEncoder.encode(searchStr, Charset.defaultCharset()));
        RequestEntity<Void> request = RequestEntity.get(URI.create(url))
                .accept(MediaType.APPLICATION_JSON)
                .header("user-agent", "my-giantbomp-server")
                .build();

        ResponseEntity<GiantGameResponse> response = restTemplate.exchange(request, GiantGameResponse.class);
        return response.getBody();
    }
}

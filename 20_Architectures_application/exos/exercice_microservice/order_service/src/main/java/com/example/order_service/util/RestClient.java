package com.example.order_service.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RestClient<T> {
    private final String apiURL = "http://localhost:8080/";
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    public RestClient() {
        restTemplate = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "*/*");
        httpHeaders.add("content-type", "application/json");
    }

    public T get(String uri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> responseEntity = restTemplate.exchange(apiURL+uri, HttpMethod.GET, requestEntity, type);
        return responseEntity.getBody();
    }
}

package com.sk.resttemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateExample {
    public static void main(String[] args) {
        // Create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Set up the headers with the API key
        HttpHeaders headers = new HttpHeaders();
      //  headers.set("Authorization", "Bearer YOUR_API_KEY");

        // Create an HttpEntity with the headers
       HttpEntity<String> entity = new HttpEntity<>(headers);

        // Specify the URL
        String url = "https://dummyjson.com/products/1";

        // Make the GET request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        // Print the response status and body
        System.out.println("Status code: " + response.getStatusCodeValue());
        System.out.println("Response body: " + response.getBody());
    }
}

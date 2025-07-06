package com.sk.resttemplate;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestTemplateExample4 {

    public static void main(String[] args) throws JsonProcessingException {
        RestTemplate restTemplate=new RestTemplate();
       String jsonResponse= restTemplate.getForObject("https://dummyjson.com/products/1", String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonResponse);
        System.out.println(root);
        String title = root.path("title").asText();
        System.out.println("Title: " + title);

    }
}

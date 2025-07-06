package com.sk.resttemplate;


import org.springframework.web.client.RestTemplate;

public class RestTemplateExample2 {

    public static void main(String[] args) {
        RestTemplate restTemplate=new RestTemplate();
        String jsonResponse = restTemplate.getForObject("https://dummyjson.com/products/1", String.class);
        System.out.println(jsonResponse);
    }
}

package com.sk.resttemplate;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestTemplateExample3 {

    public static void main(String[] args) {
        RestTemplate restTemplate=new RestTemplate();
       ResponseEntity<Map> response= restTemplate.getForEntity("https://dummyjson.com/products/1", Map.class);
        Map<String,Object> jsonMap=response.getBody();
        System.out.println(jsonMap);
        System.out.println(jsonMap.get("title"));
        System.out.println("-----------------");
        jsonMap.forEach((key, value) -> System.out.println(key + "--" + value));
    }
}

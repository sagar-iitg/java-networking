package com.sk.java11.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Example2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient javaClient=HttpClient.newHttpClient();

        HttpRequest request=HttpRequest.newBuilder().
                uri(URI.create("https://dummyjson.com/products/1")).
                GET().build();

        HttpResponse<String> response=javaClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());



    }
}

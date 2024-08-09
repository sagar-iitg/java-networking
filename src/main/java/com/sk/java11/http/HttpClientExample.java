package com.sk.java11.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.io.IOException;

public class HttpClientExample {
    public static void main(String[] args) {
        // Create an HttpClient instance
        HttpClient client = HttpClient.newHttpClient();

        // Build an HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/todos/2"))
            .build();

        // Send the request and get the response
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            // Print the response status code and body
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

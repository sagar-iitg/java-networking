package com.sagar.http.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class ExampleWithDeleteRequest {

    public static void main(String[] args) {
        // Define the API URL for the DELETE request
        String apiUrl = "https://dummyjson.com/products/1";

        try {
            // Create a URL object with the specified API URL
            URL url = new URL(apiUrl);

            // Open a connection to the URL using HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println("con---"+  connection);

            // Set the request method to DELETE
            connection.setRequestMethod("DELETE");

            // Get the HTTP response code
            int statusCode = connection.getResponseCode();

            // Check if the response code is 200 (OK)
            if (statusCode == 200) {
                System.out.println("DELETE Request Successful");
            } else {
                System.out.println("Error: HTTP Request failed with response code " + statusCode);
            }

        } catch (IOException e) {
            // Handle IO exceptions
            throw new RuntimeException(e);
        }
    }
}

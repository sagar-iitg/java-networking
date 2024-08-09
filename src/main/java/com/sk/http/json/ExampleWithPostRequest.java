package com.sagar.http.json;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExampleWithPostRequest {

    public static void main(String[] args) {
        // Define the API URL for the POST request
        String apiUrl = "https://dummyjson.com/products/add";

        try {
            // Create a URL object with the specified API URL
            URL url = new URL(apiUrl);

            // Open a connection to the URL using HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println(connection);

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Enable input/output streams for POST data
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // Set content type
            connection.setRequestProperty("Content-Type", "application/json");

            // Create a JSON object with data to be sent in the POST request
            JSONObject postData = new JSONObject();
            postData.put("title", "BMW Pencil");
            postData.put("description", "description---Pencil");
            // Add other product data as needed

            // Write the JSON data to the output stream
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = postData.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Get the HTTP response code
            int statusCode = connection.getResponseCode();

            // Check if the response code is 200 (OK)
            if (statusCode == 200) {
                // Read the response from the API using BufferedReader and streams
                try (BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();

                    // Read each line of the response and append it to the StringBuilder
                    String line;
                    while ((line = bf.readLine()) != null) {
                        response.append(line);
                    }

                    // Print the entire JSON response
                    System.out.println(response);

                    // Parse the JSON response using JSONObject from org.json library
                    JSONObject jsonResponse = new JSONObject(response.toString());

                    // Extract any relevant information from the JSON response
                    // ...

                }
            } else {
                System.out.println("Error: HTTP Request failed with response code " + statusCode);
            }

        } catch (IOException e) {
            // Handle IO exceptions
            throw new RuntimeException(e);
        }
    }
}

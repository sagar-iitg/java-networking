package com.sagar.http.json;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExampleWithPutRequest {

    public static void main(String[] args) {
        // Define the API URL for the PUT request
        String apiUrl = "https://dummyjson.com/products/1";

        try {
            // Create a URL object with the specified API URL
            URL url = new URL(apiUrl);

            // Open a connection to the URL using HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println(connection);

            // Set the request method to PUT
            connection.setRequestMethod("PUT");

            // Enable input/output streams for PUT data
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // Set content type
            connection.setRequestProperty("Content-Type", "application/json");

            // Create a JSON object with data to be sent in the PUT request
            JSONObject putData = new JSONObject();
            putData.put("title", "iPhone Galaxy +1");

            // Write the JSON data to the output stream
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = putData.toString().getBytes("utf-8");
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
                    System.out.println(jsonResponse.getString("title"));

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

package com.sagar.http.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReadJsonFromUrl {

    public String jsonResponse() {
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/rest-get-simple");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Getting the response code
            int responseCode = connection.getResponseCode();
            // System.out.println("Response Code: " + responseCode);
            StringBuilder response=new StringBuilder();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response from the API using BufferedReader and streams
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    String jsonString = response.toString();
                    //System.out.println(jsonString);
                    return  jsonString;
                }

            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

package com.sagar.http.json;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Example6 {

    public static void main(String[] args) {
        //HttpURLConnection connection = null;
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/todos/2");
            //System.out.println(url.getPath());
            //System.out.println(url.getQuery());



            //HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //connection.setRequestMethod("GET");

            // Getting the response code
           // int responseCode = connection.getResponseCode();
            //System.out.println("Response Code: " + responseCode);

           // if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response from the API using BufferedReader and streams
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {

                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    System.out.println("API Response: " + response.toString());
                    // Parse JSON response
                    JSONObject jsonResponse = new JSONObject(response.toString());
                    int userId = jsonResponse.getInt("userId");
                    int id = jsonResponse.getInt("id");
                    String title = jsonResponse.getString("title");
                    boolean completed = jsonResponse.getBoolean("completed");
                    System.out.println(userId+" "+id+" "+title+" "+completed);
                }
           // } else {
                //System.out.println("Error: HTTP Request failed with response code " + responseCode);
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.sagar.http.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class HariMohanTestExam {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/rest-get-simple");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Getting the response code
            int responseCode = connection.getResponseCode();
          //  System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response from the API using BufferedReader and streams
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    // Print the raw response (optional)
                  //  System.out.println("API Response: " + response.toString());
                    int index=response.toString().indexOf("hobbies");
                    //System.out.println(index);
                    String[] substring = response.toString().substring(index, response.toString().length() - 1).split(":");
                    String check=substring[1];
                   // System.out.println(check);
                    String substring1 = check.substring(1, check.length() - 1);
                    String[] list=substring1.split(",");
                    for (String i:list) {
                        System.out.println(i.substring(1,i.length()-1));

                    }


                }
            } else {
                System.out.println("Error: HTTP Request failed with response code " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

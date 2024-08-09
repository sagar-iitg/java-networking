package com.sagar.http.json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Example4 {

    public static void main(String[] args) {
        String apiUrl="https://dummyjson.com/products/1";
        try{
            URL url=new URL(apiUrl);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            System.out.println(connection);
            connection.setRequestMethod("GET");
            int statusCode=connection.getResponseCode();
            if(statusCode==200){

                try(BufferedReader bf=new BufferedReader(new InputStreamReader(connection.getInputStream()))){

                    StringBuilder response=new StringBuilder();

                    String line;
                    while ((line= bf.readLine())!=null){
                        response.append(line);
                    }
                    System.out.println(response);

                    JSONObject json=new JSONObject(response.toString());
                    System.out.println(json);
                    int p=json.getInt("price");
                    System.out.println(p);

                    JsonObject json2 = JsonParser.parseString(response.toString()).getAsJsonObject();

                    // Extract the "price" field from the JSON object
                    int p1 = json2.getAsJsonPrimitive("price").getAsInt();
                    System.out.println(p1);
                }
            }




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

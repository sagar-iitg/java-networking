package com.sk.http.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class Example3 {


    public static void main(String[] args) {

        String param="iphone%209";
        solve(param);
    }

    private static void solve(String param){

        String apiUrl="https://dummyjson.com/products/search?q="+param;
        System.out.println(apiUrl);
        try {
            URI uri=new URI(apiUrl);
            HttpURLConnection connection= (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            int statusCode=connection.getResponseCode();
            if(statusCode==200){

                try(BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()))){

                    StringBuilder response=new StringBuilder();
                    String line;
                    while ((line=reader.readLine())!=null){
                        response.append(line);
                    }
                    System.out.println(response.toString());
                    JSONObject obj=new JSONObject(response);

                }


            }

        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }


    }
}

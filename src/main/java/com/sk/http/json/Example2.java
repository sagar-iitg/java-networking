package com.sk.http.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Example2 {
    public static void main(String[] args) {

        try{
            URI uri=new URI("https://dummyjson.com/products/1");
            HttpURLConnection connection= (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            int responseCode=connection.getResponseCode();
            if(responseCode==200){
                try(BufferedReader bf=new BufferedReader(new InputStreamReader(connection.getInputStream())))
                {

                    //processing part
                    StringBuilder res=new StringBuilder();
                    String line;
                    while((line=bf.readLine())!=null){
                        res.append(line);

                    }
                    System.out.println(res);
                    JSONObject jsonObject=new JSONObject(res.toString());
                    System.out.println(jsonObject.getInt("id"));
                    System.out.println(jsonObject.getString("description"));
                    System.out.println(jsonObject.getInt("price"));
                    System.out.println(jsonObject.getJSONArray("images"));
                    JSONArray images = jsonObject.getJSONArray("images");
                    System.out.println(images);


                }
            }





        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

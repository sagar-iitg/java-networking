package com.sagar.http.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Example5 {

    public static void main(String[] args)  {
        try{
            URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
            BufferedReader bf=new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while((line=bf.readLine())!=null){
                System.out.println(line);
            }
            bf.close();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}

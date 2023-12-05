package com.sagar.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class DailyAdviceClient {


    final private String[] adviceList={"Take Smaller bites",
            "Go for the tight jeans. No do not mmake you look fat","You might want to rethink that haircut"};
    private final Random random=new Random();

    public void go(){


        try(ServerSocketChannel serverSocketChannel=ServerSocketChannel.open()){
            serverSocketChannel.bind(new InetSocketAddress(5000));
            while (serverSocketChannel.isOpen()){
                SocketChannel clientChannel=serverSocketChannel.accept();
                PrintWriter writer=new PrintWriter(Channels.newOutputStream(clientChannel));
                String advice=getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private  String getAdvice(){
        int nextAdvice=random.nextInt(adviceList.length);
        return  adviceList[nextAdvice];
    }

    public static void main(String[] args) {

        new DailyAdviceClient().go();

    }
}

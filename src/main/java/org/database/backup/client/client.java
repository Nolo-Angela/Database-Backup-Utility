package org.database.backup.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    private static String host = "localhost";
    private static int port = 5000;

    public static void main(String[] args) {

        try(Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            out.println("Hello from client");

            String line = in.readLine();
            System.out.println(line);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void listenThread(BufferedReader out) {

        Thread listen = new Thread(() -> {
            while(true){
                try{

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    private static void sendThread(String message, PrintWriter out) {}
}

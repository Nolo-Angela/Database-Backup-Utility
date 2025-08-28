package org.database.backup.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    private static String host = "localhost";
    private static int port = 5000;

    public static void main(String[] args) {

        try(Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){

            listenThread(in);
            Scanner scanner = new Scanner(System.in);

            while(true) {
                System.out.println("Enter command: ");
                String command = scanner.nextLine();

                 out.println(command);
               //  out.flush();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void listenThread(BufferedReader in) {

        Thread listen = new Thread(() -> {
            String message;
            try{
                while((message= in.readLine())!= null) {

                System.out.println(message);}

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        listen.start();

    }

    private static void sendThread(PrintWriter out) {
        System.out.println("Enter command: ");
        Scanner scanner = new Scanner(System.in);

        Thread send = new Thread(() -> {
             try{
                 while (true){
                 //System.out.println("Enter command: ");
                 String message = scanner.nextLine();
                 out.println(message);}
             } catch (Exception e) {
                 throw new RuntimeException(e);
             }

        });

        send.start();

    }

}

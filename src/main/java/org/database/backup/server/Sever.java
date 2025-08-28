package org.database.backup.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    private static ServerSocket serverSocket;
    private static int port= 5000;


    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(port);
        startServer();


    }

    private static void startServer(){
        System.out.println("Server started");

        Thread serverThread = new Thread(()-> {
           // while (true) {
                try{
                    Socket socket = serverSocket.accept();
                    System.out.println("Client connected: " + socket.getInetAddress());

                    new Thread(new clientHandler(socket)).start();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
           // }
        });
        serverThread.start();
    }


}
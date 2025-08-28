package org.database.backup.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class clientHandler implements Runnable {

    private Socket clientSocket;

    public clientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;

    }

    public void run() {
        try(
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ){

            while(clientSocket.isConnected()) {
            String read = in.readLine();
            System.out.println(read);}

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

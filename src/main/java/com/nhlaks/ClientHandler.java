package com.nhlaks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket socket;

    private BufferedReader reader;
    private PrintWriter writer;

    private String username;

    public ClientHandler(Socket socket) {

        this.socket = socket;

        try {

            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            writer = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }

    }

    @Override
    public void run() {

        try {

            writer.println("Enter username:");

            username = reader.readLine();

            ChatServer.broadcast(username + " joined the chat.", this);

            String message;

            while ((message = reader.readLine()) != null) {

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println(username + ": " + message);

                ChatServer.broadcast(username + ": " + message, this);

            }

        } catch (IOException e) {

            System.out.println(username + " disconnected.");

        } finally {

            ChatServer.removeClient(this);

            ChatServer.broadcast(username + " left the chat.", this);

            try {
                socket.close();
            } catch (IOException ignored) {
                System.err.println("Error closing socket: " + ignored.getMessage());
            }

        }

    }

    public void sendMessage(String message) {

        writer.println(message);

    }

}
package com.nhlaks;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ChatServer {
    // Port number
    public static final int PORT = 5000;

    private static final List<ClientHandler> clients = new java.util.concurrent.CopyOnWriteArrayList<>();
    private volatile boolean running = true;

    public void startServer() {

        System.out.println("Server started...");
        System.out.println("Waiting for clients...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            // Server continuously accepts new clients
            while (running && !serverSocket.isClosed()) {

                Socket socket = serverSocket.accept();

                System.out.println("New client connected.");
               
                // Create a handler for the new client
                ClientHandler clientHandler = new ClientHandler(socket);

                clients.add(clientHandler);

                new Thread(clientHandler).start();
            }

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }

    }

    public static synchronized void broadcast(String message, ClientHandler sender) {

        for (ClientHandler client : clients) {

            if (client != sender) {
                client.sendMessage(message);
            }

        }

    }

    public static synchronized void removeClient(ClientHandler client) {

        clients.remove(client);

    }

}

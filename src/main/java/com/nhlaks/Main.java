package com.nhlaks;

/**
 * Entry point for the Multithreaded Chat Application.
 * Launches either the server or the client depending on the command-line argument provided.
 */
public class Main {

    public static void main(String[] args) {
        // Ensuring that an argument has been provided
        if (args.length == 0) {
            System.out.println("""
                    Usage:
                    Server:
                    java Main server

                    Client:
                    java Main client
                    """);
            return;
        }
        // Start the chat server
        if (args[0].equalsIgnoreCase("server")) {
            new ChatServer().startServer();

         // Start the chat client
        } else if (args[0].equalsIgnoreCase("client")) {
            new ChatClient().startClient();
        } else {
            System.out.println("Invalid argument.");
        }
    }
}

package com.nhlaks;

public class Main {

    public static void main(String[] args) {

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

        if (args[0].equalsIgnoreCase("server")) {
            new ChatServer().startServer();
        } else if (args[0].equalsIgnoreCase("client")) {
            new ChatClient().startClient();
        } else {
            System.out.println("Invalid argument.");
        }
    }
}
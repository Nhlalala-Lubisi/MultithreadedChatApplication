package com.nhlaks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    public void startClient() {

        try (

                Socket socket = new Socket(HOST, PORT);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                PrintWriter writer = new PrintWriter(
                        socket.getOutputStream(), true);

                Scanner scanner = new Scanner(System.in)

        ) {

            System.out.println(reader.readLine());

            String username = scanner.nextLine();

            writer.println(username);

            Thread receiveThread = new Thread(() -> {

                String response;

                try {

                    while ((response = reader.readLine()) != null) {

                        System.out.println(response);

                    }

                } catch (IOException ignored) {
                    System.err.println("Error reading from server: " + ignored.getMessage());
                }

            });

            receiveThread.start();

            while (true) {

                String message = scanner.nextLine();

                writer.println(message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

            }

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }

    }

}
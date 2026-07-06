# Multithreaded Chat Application

## Overview

The Multithreaded Chat Application is a console-based client-server messaging system developed using Java 21. It demonstrates socket programming, multithreading, and concurrent client communication over a TCP network.

Each connected client runs in its own thread, allowing multiple users to communicate simultaneously.

---

## Features

- Multi-client communication
- TCP Socket Programming
- Multithreaded server
- Broadcast messaging
- Username support
- Join and leave notifications
- Console-based interface
- Java 21 compatible

---

## Technologies Used

- Java 21
- Maven
- Java Sockets
- Multithreading
- JUnit 5

---

## Project Structure

```
src
├── main
│   └── java
│       └── com
│           └── nhlaks
│               ├── ChatClient.java
│               ├── ChatServer.java
│               ├── ClientHandler.java
│               └── Main.java
└── test
    └── java
        └── com
            └── nhlaks
                ├── ChatServerTest.java
                ├── ClientHandlerTest.java
                └── MainTest.java
```

---

## Requirements

- Java JDK 21
- Apache Maven 3.9+
- Visual Studio Code

---

## Build the Project

```bash
mvn clean compile
```

---

## Run the Server

```bash
java -cp target/classes com.nhlaks.Main server
```

---

## Run the Client

Open a new terminal for each client.

```bash
java -cp target/classes com.nhlaks.Main client
```

---

## Example

### Server

```
Server started...
Waiting for clients...
New client connected.
```

### Client

```
Enter username:
Nhlaks

Deon joined the chat.
Hello everyone
```

---

## Testing

Execute all unit tests with:

```bash
mvn test
```

---

## Learning Outcomes

This project demonstrates:

- Java Socket Programming
- TCP Communication
- Multithreading
- Concurrent Programming
- Object-Oriented Design
- Maven Project Management
- Unit Testing with JUnit

---

## Author

**Nhlalala Lubisi**

Advanced Diploma in Information Technology (NQF 7)

Software Development | Full-Stack Development | AI & ML

package com.nhlaks;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void shouldCreateServerInstance() {

        assertDoesNotThrow(ChatServer::new);

    }

    @Test
    void shouldCreateClientInstance() {

        assertDoesNotThrow(ChatClient::new);

    }

}
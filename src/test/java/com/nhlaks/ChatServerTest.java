package com.nhlaks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ChatServerTest {

    @Test
    void shouldUseCorrectPort() {

        assertEquals(5000, ChatServer.PORT);
    }
    
}

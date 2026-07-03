package com.nhlaks;

import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ClientHandlerTest {

    @Test
    void shouldThrowExceptionWhenSocketIsNull() {

        NullPointerException ex = assertThrows(NullPointerException.class,
            () -> new ClientHandler((Socket) null));
        assertNotNull(ex);

    }

}

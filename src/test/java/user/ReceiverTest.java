package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiverTest {
    private Receiver receiver1;
    private Receiver receiver2;

    @BeforeEach
    void setUp() {
        receiver1 = new Receiver();
        receiver2 = new Receiver();
    }

    @Test
    void id() {
        assertEquals(1, receiver2.getId() - receiver1.getId());
    }
    @Test
    void update() {
        assertEquals(0, receiver1.update("your order is great"));
        assertEquals(0, receiver2.update("your order is great, too"));
    }
}
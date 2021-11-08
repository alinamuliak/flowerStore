package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenderTest {

    private Sender sender1;
    private Sender sender2;
    @BeforeEach
    void setUp() {
        sender1 = new Sender();
        sender2 = new Sender();
    }

    @Test
    void id() {
        assertEquals(1, sender2.getId() - sender1.getId());
    }
    @Test
    void update() {
        assertEquals(0, sender1.update("order 1 updated"));
        assertEquals(0, sender2.update("order 2 updated"));
    }
}
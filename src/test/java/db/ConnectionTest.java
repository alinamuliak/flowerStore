package db;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionTest {

    private Connection connection;
    private Connection connection1;
    @BeforeEach
    void setUp() {
        connection = Connection.getConnection();
        connection1 = Connection.getConnection();
    }

    @Test
    void getConnection() {
        assertSame(connection, connection1);
    }
}
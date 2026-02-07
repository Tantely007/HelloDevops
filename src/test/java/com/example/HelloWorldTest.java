package test.java.com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {
    @Test
    void testSum() {
        assertEquals(5, HelloWorld.sum(2,3));
    }
}

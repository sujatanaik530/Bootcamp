package com.perscholas.junitprotected;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitProtectedTest {
    @Test
    public void testReturnName() {
        assertEquals(JUnitProtected.returnName(), "John");
    }
    @Test
    public void testAddNums() {
        assertEquals(JUnitProtected.addNums(23, 34), 57);
    }
}

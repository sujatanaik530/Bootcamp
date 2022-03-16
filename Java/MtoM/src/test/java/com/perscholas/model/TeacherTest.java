package com.perscholas.model;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {
    private static Teacher expected;
    @Test
    public void testTeacherGetters() {
        expected = new Teacher("Don", 100, null);
        assertEquals(expected.gettName(), "Don");
        assertEquals(expected.gettSalary(), 100);
    }
}

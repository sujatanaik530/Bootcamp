package com.perscholas.model;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    @Test
    public void testStudent() {
        Student a = new Student();
        a.setsID(1);
        a.setsEmail("mgabriel@perscholas.org");
        a.setsFName("Mike");
        a.setsLName("Gabriel");

        Student b = new Student();
        b.setsID(1);
        b.setsEmail("mgabriel@perscholas.org");
        b.setsFName("Mike");
        b.setsLName("Gabriel");

        assertEquals(a, b);
    }

}

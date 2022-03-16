package com.perscholas;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestThisTest {
    TestThis t;
    @Test
    public void testGetNameAtIndex() {
        t = new TestThis();
        assertEquals(t.getNameAtIndex(2), "Tony");
        assertEquals(t.getNameAtIndex(0), "Mike");
    }
    @Test
    public void testAddName() {
        t = new TestThis();
        t.addName("Jared");
        assertEquals(t.getNames(), Arrays.asList(new String[] {"Mike", "Bairon", "Tony", "Jared"}));
    }
}

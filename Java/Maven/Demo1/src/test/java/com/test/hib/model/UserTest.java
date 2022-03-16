package com.test.hib.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    static SessionFactory f;
    static Session s;
    static User actual;
    @BeforeAll
    public static void setup() {
        f = new Configuration().configure().buildSessionFactory();
        s = f.openSession();
        actual = new User("Sujata", "sn@gmail.com", "pass", 20, 10000, "St.Paul");
    }
    @Test
    public void testGetters() {
        assertEquals("Sujata", actual.getFullname());
        assertEquals("sn@gmail.com", actual.getEmail());
        assertEquals("pass", actual.getPassword());
        assertEquals(20, actual.getAge());
        assertEquals(10000, actual.getSalary());
        assertEquals("St.Paul", actual.getCity());
    }
    @Test
    public void testSetters() {
        actual.setFullname("Don");
        actual.setEmail("db@gmail.com");
        actual.setPassword("pass");
        actual.setAge(20);
        actual.setSalary(10000);
        actual.setCity("New York City");
        assertEquals("Don", actual.getFullname());
        assertEquals("db@gmail.com", actual.getEmail());
        assertEquals("pass", actual.getPassword());
        assertEquals(20, actual.getAge());
        assertEquals(10000, actual.getSalary());
        assertEquals("New York City", actual.getCity());
    }
    @AfterAll
    public static void cleanup() {
        s.close();
        f.close();
    }
}

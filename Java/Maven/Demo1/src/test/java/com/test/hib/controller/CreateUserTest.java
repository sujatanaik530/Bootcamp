package com.test.hib.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.TypedQuery;
import java.util.List;

public class CreateUserTest {
    static SessionFactory f;
    static Session s;
    @BeforeAll
    public static void setup() {
        f = new Configuration().configure().buildSessionFactory();
        s = f.openSession();
    }

    @Test
    public void testCreateAUserTable() {
        CreateUser c = new CreateUser();
        c.createAUserTable();
        String qy = "select u from User u";
        TypedQuery q = s.createQuery(qy);
        List<Object[]> results = q.getResultList();
        assertTrue(results.size()>0);
    }

    @AfterAll
    public static void cleanup() {
        s.close();
        f.close();
    }
}

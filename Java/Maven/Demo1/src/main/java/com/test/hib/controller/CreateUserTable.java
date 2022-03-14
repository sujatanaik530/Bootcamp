package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateUserTable {
    public static void main(String[] args) {
        Configuration cfg = new Configuration(); // activate connection
        Configuration c = cfg.configure(); // look for hibernate.cfg.xml for DB info
        SessionFactory factory = c.buildSessionFactory(); // return a DB connection

        // or do it all in one line!
        //SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession(); // create a session for available connection

        // transaction-related code is not needed, only needed for DML (data manipulation)
        //Transaction t = session.beginTransaction();

        User uone = new User(); // this creates a table! all by creating a new User obj!

        // below transaction-related code is not needed
        //t.commit();

        System.out.println("successfully created user table");
        session.close();
        factory.close();
    }
}

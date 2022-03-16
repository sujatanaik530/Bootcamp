package com.perscholas.controller;


import com.perscholas.model.Cohort;
import com.perscholas.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class TheController {
    public void createTables() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();
        s.close();
        f.close();
    }

    public void insertRows() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();
        Transaction t = s.beginTransaction();

        // create cohorts
        Cohort c1 = new Cohort("Java Developer", "12 weeks");
        Cohort c2 = new Cohort("FullStack Developer", "20 Weeks");
        Cohort c3 = new Cohort("Python Developer", "12 Weeks");
        Cohort c4 = new Cohort("Data Analytics", "12 weeks");
        Cohort c5 = new Cohort("Data Engineering", "16 Weeks");
        Cohort c6 = new Cohort("Security", "12 Weeks");
        Cohort c7 = new Cohort("Frontend Developer", "12 weeks");
        Cohort c8 = new Cohort("Selenium", "4 weeks");

        // save cohorts
        s.save(c1);
        s.save(c2);
        s.save(c3);
        s.save(c4);
        s.save(c5);
        s.save(c6);
        s.save(c7);
        s.save(c8);

        // create cohort list for teacher 1
        Set<Cohort> cs1 = new HashSet<>();
        cs1.add(c1);
        cs1.add(c2);

        // create cohort list for teacher 2
        Set<Cohort> cs2 = new HashSet<>();
        cs2.add(c3);
        cs2.add(c4);
        cs2.add(c5);

        // create cohort list for teacher 3
        Set<Cohort> cs3 = new HashSet<>();
        cs3.add(c6);

        // create cohort list for teacher 4
        Set<Cohort> cs4 = new HashSet<>();
        cs4.add(c7);
        cs4.add(c2);

        // create teachers
        Teacher t1 = new Teacher("Haseeb", 100, cs1);
        Teacher t2 = new Teacher("Jenny", 100, cs2);
        Teacher t3 = new Teacher("Charlie", 100, cs3);
        Teacher t4 = new Teacher("Erica", 100, cs4);
        Teacher t5 = new Teacher("Sujata", 100, null);

        // save teachers
        s.save(t1);
        s.save(t2);
        s.save(t3);
        s.save(t4);
        s.save(t5);

        t.commit();
        s.close();
        f.close();
    }
}

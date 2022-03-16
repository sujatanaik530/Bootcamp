package com.perscholas.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

public class MyController {
    public void createManyToOne() {
        // This method will generate Department and Teacher tables for many-to-one
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();
        s.close();
        f.close();
    }
    public void insertRecords() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();
        Transaction t = s.beginTransaction();

        // two ways to insert records: insert query or Hibernate built-in methods

        Department dept1 = new Department();
        //dept1.setDid(1);  // not needed, auto-generated
        dept1.setDname("HR");
        s.save(dept1);

        Department dept2 = new Department();
        dept2.setDname("Computer Science");
        s.save(dept2);

        Department dept3 = new Department();
        dept3.setDname("Payroll");
        s.save(dept3);

        Teacher t1 = new Teacher();
        t1.setTeachername("Neil");
        t1.setDept(dept3);
        t1.setSalary("10000");
        s.save(t1);

        Teacher t2 = new Teacher();
        t2.setTeachername("Haseeb");
        t2.setDept(dept1);
        t2.setSalary("10000");
        s.save(t2);

        Teacher t3 = new Teacher();
        t3.setTeachername("James");
        t3.setDept(dept1);
        t3.setSalary("10000");
        s.save(t3);

        Teacher t4 = new Teacher();
        t4.setTeachername("Alex");
        t4.setDept(dept2);
        t4.setSalary("10000");
        s.save(t4);

        t.commit();
        s.close();
        f.close();
    }
    public void showRecords() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();

        TypedQuery q = s.createQuery("select t from Teacher t");
        List<Teacher> results = q.getResultList();
        for (Teacher t: results) {
            System.out.format("%-3d%-15s%-7s%n", t.getTit(), t.getTeachername(), t.getSalary());
        }

        s.close();
        f.close();
    }
}

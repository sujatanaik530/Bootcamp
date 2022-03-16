package com.perscholas.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyController {
    public void createManyToOne() {
        // This method will generate Department and Teacher tables for one-to-many
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

        Teacher t1 = new Teacher();
        t1.setTeachername("Neil");
        t1.setSalary("10000");
        s.save(t1);

        Teacher t2 = new Teacher();
        t2.setTeachername("Haseeb");
        t2.setSalary("10000");
        s.save(t2);

        Teacher t3 = new Teacher();
        t3.setTeachername("James");
        t3.setSalary("10000");
        s.save(t3);

        Teacher t4 = new Teacher();
        t4.setTeachername("Alex");
        t4.setSalary("10000");
        s.save(t4);

        Set<Teacher> teacherList = new HashSet<>();
        teacherList.add(t1);
        teacherList.add(t2);
        teacherList.add(t3);
        teacherList.add(t4);

        Teacher t5 = new Teacher();
        t5.setTeachername("Sujata");
        t5.setSalary("10000");
        s.save(t5);

        Teacher t6 = new Teacher();
        t6.setTeachername("Jared");
        t6.setSalary("10000");
        s.save(t6);

        Teacher t7 = new Teacher();
        t7.setTeachername("Jennifer");
        t7.setSalary("10000");
        s.save(t7);

        Set<Teacher> teacherList2 = new HashSet<>();
        teacherList2.add(t5);
        teacherList2.add(t6);
        teacherList2.add(t7);

        Department dept1 = new Department();
        //dept1.setDid(1);  // not needed, auto-generated
        dept1.setDname("HR");
        dept1.setTeachersList(teacherList);

        Department dept2 = new Department();
        dept2.setDname("Computer Science");
        dept2.setTeachersList(teacherList2);

        Department dept3 = new Department();
        dept3.setDname("Payroll");

        s.save(dept1);
        s.save(dept2);
        s.save(dept3);

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

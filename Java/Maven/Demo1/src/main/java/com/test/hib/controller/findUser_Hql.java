package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

public class findUser_Hql {
    public void findAllUsers() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();

        // example HQL to get all records from user table
        String hql = "From User";

        // equivalent HQL
        String hql1 = "SELECT u From User u";

        TypedQuery q = s.createQuery(hql1);
        List<User> allUsers = q.getResultList();
        for (User eachUser: allUsers) {
            System.out.println("User id: " + eachUser.getId()
                                + " Full name: " + eachUser.getFullname());
        }
        s.close();
        f.close();
    }

    public void getRecordbyId() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT U FROM User U WHERE U.id > 3 ORDER BY U.id DESC";

        TypedQuery query = session.createQuery(hql);

        List<User> list  =  query.getResultList();
        System.out.println();
        for (User u : list) {
            System.out.println("User Id: " + u.getId() + "|"
                                + " Full name: " + u.getFullname() + "|"
                                + "Email: " + u.getEmail() + "|"
                                + "password: " + u.getPassword());
        }
        session.close();
        factory.close();
    }

    public void getMaxSalary() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT max(u.salary) FROM User u";

        TypedQuery query = session.createQuery(hql);

        double maxSalary  =  (Double)query.getSingleResult();
        System.out.println("Max Salary = " + maxSalary);
        session.close();
        factory.close();
    }

    public void getTotalRows() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "select count(u) from User u"; // The table/class name is CASE-SENSITIVE!
        TypedQuery query = session.createQuery(hql);

        long rowCount = (Long)query.getSingleResult();
        System.out.println("Row count in long = " + rowCount);

        // another way to do it
        // printed in square brackets, because of List
        List listRowCount = query.getResultList();
        System.out.println(("Row count in list = " + listRowCount));
        session.close();
        factory.close();
    }

    public void getAllUsers(int userid) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "select u from User u where u.id = :userid";
        TypedQuery tq = session.createQuery(hql);
        tq.setParameter("userid", userid);
        List<User> resultUsers = tq.getResultList();
        for (User u: resultUsers) {
            System.out.println("User Id: " + u.getId() + "|"
                    + " Full name: " + u.getFullname() + "|"
                    + "Email: " + u.getEmail() + "|"
                    + "password: " + u.getPassword());
        }

        session.close();
        factory.close();
    }
}

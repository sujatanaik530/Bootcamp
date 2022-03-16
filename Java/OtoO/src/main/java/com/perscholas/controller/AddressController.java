package com.perscholas.controller;

import com.perscholas.model.Address;
import com.perscholas.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class AddressController {
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

        Address a1 = new Address();
        a1.setStreetNumber("Third St");
        a1.setCity("New York");
        a1.setZipcode(11123);
        a1.setState("NY");
        a1.setCountry("USA");
        Person p1 = new Person();
        p1.setName("Mickey Mouse");
        p1.setAge(25);
        p1.setEmail("mmouse@gmail.com");
        p1.setHobbies("Sleeping");
        p1.setMyaddress(a1);

        Address a2 = new Address();
        a2.setStreetNumber("Fifth St");
        a2.setCity("St.Paul");
        a2.setZipcode(55122);
        a2.setState("MN");
        a2.setCountry("USA");
        Person p2 = new Person();
        p2.setName("Charlie Brown");
        p2.setAge(60);
        p2.setEmail("cbrown@gmail.com");
        p2.setHobbies("Playing");
        p2.setMyaddress(a2);

        s.save(p1);
        s.save(p2);
        s.save(a1);
        s.save(a2);

        t.commit();
        s.close();
        f.close();
    }
    public void insertUserInputRows() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();
        Transaction t = s.beginTransaction();
        Scanner uIn = new Scanner(System.in);
        boolean keepGoing = true;
        do {
            System.out.println("Enter name: ");
            String name = uIn.nextLine();
            System.out.println("Enter age: ");
            String age = uIn.nextLine();
            System.out.println("Enter email: ");
            String email = uIn.nextLine();
            System.out.println("Enter hobbies: ");
            String hobbies = uIn.nextLine();
            System.out.println("Enter street name: ");
            String stname = uIn.nextLine();
            System.out.println("Enter city: ");
            String city = uIn.nextLine();
            System.out.println("Enter zipcode: ");
            int zipcode = uIn.nextInt();
            uIn.nextLine();
            System.out.println("Enter state: ");
            String state = uIn.nextLine();
            System.out.println("Enter country: ");
            String country = uIn.nextLine();
            Address a = new Address();
            a.setStreetNumber(stname);
            a.setCity(city);
            a.setZipcode(zipcode);
            a.setState(state);
            a.setCountry(country);
            Person p = new Person();
            p.setMyaddress(a);
            p.setHobbies(hobbies);
            p.setEmail(email);
            p.setAge(Integer.parseInt(age));
            p.setName(name);
            s.save(a);
            s.save(p);
            System.out.println("\nContinue adding data? (y/n) ");
            String reply = uIn.nextLine();
            if (reply.equalsIgnoreCase("y")) {
                keepGoing = true;
            }
            else {
                keepGoing = false;
            }
        } while (keepGoing);
        t.commit();
        s.close();
        f.close();
    }
    public void getPersonInfo() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();

        // p.id -> instead of p.personId because of annotation Id associated with personID in Person class
        // same with a.id -> instead of a.addressID
        TypedQuery tq = s.createQuery("select p, a from Person p inner join Address a on a.id = p.id");
        List<Object[]> results = tq.getResultList();
        for (Object[] r: results) {
            System.out.println(r[0]);
            System.out.println(r[1]);
            Person p = (Person) r[0];
            Address a = (Address) r[1];
            System.out.println(p.getName() + " " + p.getAge());
            System.out.println(p.getMyaddress().getCity());
            System.out.println(a.getCity());
        }

        s.close();
        f.close();
    }
}

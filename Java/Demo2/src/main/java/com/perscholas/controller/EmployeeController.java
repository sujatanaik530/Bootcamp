package com.perscholas.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.perscholas.model.Employee;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    public void createEmployeeTable()
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();
        Employee uone = new Employee();
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }

    public void insertRecordsIntoEmployeeTable() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        String updateQuery;

        updateQuery = "insert into Employee (addressLine, city, job, name, officeCode, salary, startDate, zipcode) values ('24-10', 'NYC', 'Ceo', 'Tom Thele', 1, '25600', '2021-09-09 18:32:11.000000', '11102'), ('35-16', 'LA', 'Manager', 'Jenny Ji', 2, '15600', '2021-09-09 18:32:11.000000', '11103'), ('34-10', 'NJ', 'Cfo', 'M Joseph', 3, '16600', '2021-09-09 18:32:11.000000', '11583'), ('44-20', 'NYC', 'Manager', 'James Judge', 4, '185600', '2021-09-09 18:32:11.000000', '18983'), ('44-20', 'Dallas', 'Manager', 'Ramon Rio', 5, '36600', '2021-09-09 18:32:11.000000', '14783'), ('44-40', 'LA', 'Manager', 'James Santana', 6, '78600', '2021-09-09 18:32:11.000000', '18483'), ('484-40', 'LA', 'Manager', 'Elded Oreo', 6, '50089', '2021-09-09 18:32:11.000000', '155483')";

        TypedQuery tq = session.createSQLQuery(updateQuery);
        tq.executeUpdate();

        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }

    public void insertUserInputRecordsIntoEmployeeTable() {
        String name;
        int salary;
        String job;
        String addressLine;
        String zipcode;
        String city;
        int officeCode;

        Scanner uIn = new Scanner(System.in);
        System.out.println("Enter name: ");
        name = uIn.nextLine();
        System.out.println("Enter salary: ");
        salary = uIn.nextInt();
        uIn.nextLine();
        System.out.println("Enter job: ");
        job = uIn.nextLine();
        System.out.println("Enter address: ");
        addressLine = uIn.nextLine();
        System.out.println("Enter zip code: ");
        zipcode = uIn.nextLine();
        System.out.println("Enter city: ");
        city = uIn.nextLine();
        System.out.println("Enter office code: ");
        officeCode = uIn.nextInt();
        uIn.nextLine();

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        String updateQuery;

        updateQuery = "insert into Employee (addressLine, city, job, name, officeCode, salary, startDate, zipcode) values (?, ?, ?, ?, ?, ?, ?, ?)";

        TypedQuery tq = session.createSQLQuery(updateQuery);
        tq.setParameter(1, addressLine);
        tq.setParameter(2, city);
        tq.setParameter(3, job);
        tq.setParameter(4, name);
        tq.setParameter(5, officeCode);
        tq.setParameter(6, salary);
        tq.setParameter(7, new Date());
        tq.setParameter(8, zipcode);
        tq.executeUpdate();

        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }

    public void getAllEmployeeInfo() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // transaction not needed for reading data
        // transaction is only needed to write data

        TypedQuery q = session.getNamedQuery("AllEmployees");
        List<Employee> results = q.getResultList();
        System.out.println("\nUsing named query");
        for (Employee r: results) {
            System.out.println(r.getName() + " " + r.getAddressLine() + " " + r.getCity() + " " + r.getZipcode());
        }

        factory.close();
        session.close();
    }

    public void findEmployeeByID() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Scanner uIn = new Scanner(System.in);
        System.out.println("\nEnter employee id: ");
        int id = uIn.nextInt();
        TypedQuery q = session.getNamedQuery("GetEmployeeByID");
        q.setParameter("id", id);

        List<Employee> result = q.getResultList();
        System.out.println("\nUsing named queries");
        for (Employee r: result) {
            System.out.println(r.getName() + " " + r.getAddressLine() + " " + r.getCity() + " " + r.getZipcode());
        }

        session.close();
        factory.close();
    }

    public void findEmployeeByName() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();

        Scanner uIn = new Scanner(System.in);
        System.out.println("\nEnter employee name: ");
        String name = uIn.nextLine();

        TypedQuery q = s.getNamedQuery("FindEmployeeByName");
        q.setParameter("name", name);

        List<Employee> result = q.getResultList();
        System.out.println("\nAnother one using a new named query");
        for (Employee r: result) {
            System.out.println(r.getName() + " " + r.getAddressLine() + " " + r.getCity() + " " + r.getZipcode());
        }

        s.close();
        f.close();
    }

    public void displayDeptAlias() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();

        TypedQuery q = s.getNamedQuery("EmployeeDeptAlias");
        List<Object[]> results = q.getResultList();
        System.out.println("\nYet another named query - case statement");
        for (Object[] r: results) {
//            System.out.println(r[0] + " " + r[1] + " " + r[2]);
            System.out.format("%-5d%-25s%-20s%n", r[0], r[1], r[2]);
        }

        s.close();
        f.close();
    }
}

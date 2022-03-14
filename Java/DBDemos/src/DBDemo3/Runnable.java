package DBDemo3;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Runnable {
    public static void main (String[] args) throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        String url =  "jdbc:mariadb://localhost/classicmodels";
        final String USER = "root";
        final String PASS = "password";
        Connection conn = DriverManager.getConnection(url, USER, PASS);

        // Use PreparedStatement to protect against SQL dependency injection attacks
        // improved performance
        // pre-complies the SQL statements

        // The "?" is a parameter placeholder. Use the PreparedStatement methods to set the parameters.
        String SelectSQL = "select * from employees where employeeNumber = ?";
        PreparedStatement mystmt = conn.prepareStatement(SelectSQL);
        mystmt.setInt(1, 1002);
        ResultSet result = mystmt.executeQuery();
        while(result.next())
        {
            String name = result.getString("firstName");
            String email  = result.getString("email");
            System.out.println(name +" | " + email);
        }

        System.out.println();
        Scanner uIn = new Scanner(System.in);
        System.out.println("Customers from which country? ");
        String fromCountry = uIn.nextLine();
        System.out.println();
        System.out.println("Customers from " + fromCountry);

        //SelectSQL = "select * from customers where country = ?";
        // Instead of the above, use the SQL query stored in the SQLQueries class.
        mystmt = conn.prepareStatement(SQLQueries.customerNamePhoneByCountry);
        mystmt.setString(1, fromCountry);
        result = mystmt.executeQuery();
        System.out.println();
        System.out.format("%-50s%-20s%n", "Customer Name", "Customer Phone");
        while(result.next())
        {
            String name = result.getString("customerName");
            String phone  = result.getString("phone");
            System.out.format("%-50s%-20s%n", name, phone);
        }

        mystmt = conn.prepareStatement(SQLQueries.createTempTable);
        int rowCount = mystmt.executeUpdate();
        System.out.println();

        HashMap<Integer,String> idsNames = new HashMap<>();
        idsNames.put(1, "Student 1");
        idsNames.put(2, "Student 2");
        idsNames.put(3, "Student 3");
        idsNames.put(4, "Student 4");
        idsNames.put(5, "Student 5");
        idsNames.put(6, "Student 6");
        idsNames.put(7, "Student 7");

        for (Integer i : idsNames.keySet()) {
            int id = i;
            String name = idsNames.get(i);
            mystmt = conn.prepareStatement(SQLQueries.insertIntoTempTable);
            mystmt.setInt(1, id);
            mystmt.setString(2, name);
            mystmt.executeUpdate();
        }

        conn.close();
    }
}

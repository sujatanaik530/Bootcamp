package HandsOnActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Runnable {
    public static void main(String[] args) throws Exception {
        Class.forName(SQLConnection.driver);
        Connection conn = DriverManager.getConnection(SQLConnection.classicmodelsURL, SQLConnection.user, SQLConnection.password);

        System.out.println("\nSelect all employees whose last name is less than 5 characters in length.");
        // Query 4
        PreparedStatement myStmt = conn.prepareStatement(SQLQueries.lastNameShorterThan);
        myStmt.setInt(1,5);
        ResultSet result = myStmt.executeQuery();

        while (result.next()) {
            String fName = result.getString("firstname");
            String lName = result.getString("lastname");
            System.out.println(fName + " " + lName);
        }

        System.out.println("\nUpdate the extension number of employees whose officecode is 2 and new extension number will be “5698.”");
        // Query 3
        myStmt = conn.prepareStatement(SQLQueries.updateNewExtension);
        myStmt.setString(1, "x5698");
        myStmt.setString(2, "2");
        myStmt.executeUpdate();

        System.out.println("\nSelect all orderdetails whose officecode is 1,4, and 6");
        // Query 2
        myStmt = conn.prepareStatement(SQLQueries.allOrderDetailsOfficeCodennn);
        myStmt.setInt(1, 1);
        myStmt.setInt(2, 4);
        myStmt.setInt(3, 6);
        result = myStmt.executeQuery();
        while (result.next()) {
            String cName = result.getString("CustomerName");
            String eFirstName = result.getString("firstName");
            String eLastName = result.getString("lastName");
            System.out.println(cName + " " + eFirstName + " " + eLastName);
        }
        result.last();
        System.out.println();
        System.out.println(result.getRow() + " rows returned.");



        conn.close();
    }
}

package DBDemo1;

import java.sql.*;

public class Runnable {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        Class.forName("org.mariadb.jdbc.Driver");
        String url =  "jdbc:mariadb://localhost/classicmodels";
        final String USER = "root";
        final String PASS = "password";
        Connection conn = DriverManager.getConnection(url, "root", "password");
        String SelectSQL = "Select * FROM employees";
        Statement stmt = conn.createStatement();
        ResultSet result =  stmt.executeQuery(SelectSQL);
        while(result.next())
        {
            String name = result.getString("firstName");
            String email  = result.getString("email");
            System.out.println(name +" | " + email);
        }
        conn.close();
    }
}

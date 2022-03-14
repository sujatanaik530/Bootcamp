package Demo1;

import org.mariadb.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Runnable {
    public static void main(String[] args) throws SQLException {
        DAODemo1 daoObj = new DAODemo1();
        daoObj.connect();

        String lastNameShorterThan = "select * from employees where length(lastname) < ?";
        daoObj.ps = daoObj.conn.prepareStatement(lastNameShorterThan);
        daoObj.ps.setInt(1, 5);
        daoObj.rs = daoObj.ps.executeQuery();

        while (daoObj.rs.next()) {
            String fName = daoObj.rs.getString("firstname");
            String lName = daoObj.rs.getString("lastname");
            System.out.println(fName + " " + lName);
        }
        daoObj.dispose();
    }
}

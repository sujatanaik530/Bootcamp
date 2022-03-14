package DBDemo2;

import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;

public class RegisteringDeviceMethod1 {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    }
}

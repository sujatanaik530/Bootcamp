import java.sql.SQLException;

public class RegisteringDeviceMethod1 {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    }
}

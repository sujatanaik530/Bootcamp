package Demo1;

import java.sql.*;

public class DAODemo1 {
    private final String url = "jdbc:mariadb://localhost/classicmodels";
    private final String user = "root";
    private final String password = "password";
    private final Driver driver = new oracle.jdbc.driver.OracleDriver();

    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public void connect() throws SQLException {
        try {
            DriverManager.registerDriver(driver);
            conn =  DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void dispose() {
        try {
            if (!rs.equals(null)) {
                if (!rs.isClosed()) {
                    rs.close();
                }
            }
            if (!ps.equals(null)) {
                if (!ps.isClosed()) {
                    ps.close();
                }
            }
            if (!conn.equals(null)) {
                if (!conn.isClosed()) {
                    conn.close();
                }
            }
        }
        catch (SQLException e) {

        }
    }
}

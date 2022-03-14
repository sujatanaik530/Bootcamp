package DBDemo3;

public class SQLQueries {
    public static final String customerNamePhoneByCountry = "select * from customers where country = ?";
    public static final String createTempTable = "create table temp1 (id int, name varchar(20))";
    public static final String insertIntoTempTable = "insert into temp1 values(?, ?)";
}

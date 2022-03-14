package HandsOnActivity;

public class SQLQueries {
    public static final String allEmployeesOfficeCodenn = "select * from employees where officecode in (?, ?)";
    // orderdetails whose officecode is 1,4, and 6.
    public static final String allOrderDetailsOfficeCodennn = "SELECT * " +
            "FROM orderdetails od JOIN orders o ON od.orderNumber = o.orderNumber " +
            "JOIN customers c ON c.customerNumber = o.customerNumber " +
            "JOIN employees e ON e.employeeNumber = c.salesRepEmployeeNumber " +
            "WHERE e.officeCode IN (?, ?, ?)";
    public static final String updateNewExtension = "update employees set extension = ? where officecode = ?";
    public static final String lastNameShorterThan = "select * from employees where length(lastname) < ?";
}

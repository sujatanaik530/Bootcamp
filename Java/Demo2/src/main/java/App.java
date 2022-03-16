import com.perscholas.controller.EmployeeController;

public class App  {
    public static void main ( String[] args ) throws Exception {
        System.out.println( "Hello World!" );
        EmployeeController e = new EmployeeController();
        e.createEmployeeTable();
        e.insertRecordsIntoEmployeeTable();
        //e.insertUserInputRecordsIntoEmployeeTable();
        e.getAllEmployeeInfo();
        //e.findEmployeeByID();
        //e.findEmployeeByName();
        e.displayDeptAlias();
    }
}
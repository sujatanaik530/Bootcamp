package Employee;

public class Employee {
    protected long employeeId;
    protected String employeeName;
    protected String employeeAddress;
    protected long employeePhone;
    protected double basicSalary;
    protected final double specialAllowance = 250.80;
    protected final double hra = 1000.50;

    public Employee(long employeeId, String employeeName, String employeeAddress, long employeePhone) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
    }

    public void calculateSalary() {
        double salary = this.basicSalary + ( this.basicSalary * this.specialAllowance/100) + ( this.basicSalary *
                this.hra/100);
        System.out.println(salary);
    }

    public void calculateTransportAllowance() {
        double transportationAllowance = 0.10 * this.basicSalary;
        System.out.println(transportationAllowance);
    }
}

class Manager extends Employee {
    public Manager(long employeeId, String employeeName, String employeeAddress, long employeePhone, double basicSalary) {
        super(employeeId, employeeName, employeeAddress, employeePhone);
        this.basicSalary = basicSalary;
    }
    public void calculateTransportAllowance() {
        double transportationAllowance = 0.15 * this.basicSalary;
        System.out.println(transportationAllowance);
    }
}

class Trainee extends Employee {
    public Trainee(long employeeId, String employeeName, String employeeAddress, long employeePhone, double basicSalary) {
        super(employeeId, employeeName, employeeAddress, employeePhone);
        this.basicSalary = basicSalary;
    }
}

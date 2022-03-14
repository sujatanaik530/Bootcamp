package Banking;

public class SavingsAccount {
    private int customerID;
    private String customerName;
    private static String bankName = "TD Name";
    private double customerBalance;
    private static String currencySymbol = "$";
    private static double tax = 0.85;
    private static double mortgageTax = 0.5;
    private static final double FEES = 100;
    private double interestrate = 0.10;

    public SavingsAccount(int customerID, String customerName, double customerBalance) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerBalance = customerBalance;
    }

    public double getCustomerBalance() {
        return this.customerBalance;
    }

    public void setDeposit(double amount) {
        this.customerBalance += amount;
    }

    public void setWithdraw(double amount) {
        this.customerBalance -= amount;
    }

    public double calculateInterest() {
        return(this.customerBalance * interestrate);
    }
}

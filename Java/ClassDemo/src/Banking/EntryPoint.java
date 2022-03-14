package Banking;

public class EntryPoint {
    public static void main(String[] args) {
        SavingsAccount srn = new SavingsAccount(10, "Sujata Naik", 10000.00);
        System.out.println("Current balance: ");
        System.out.println(srn.getCustomerBalance());
        System.out.println("Depositing 1000");
        srn.setDeposit(1000);
        System.out.println(srn.getCustomerBalance());
        System.out.println("Withdrawing 3000");
        srn.setWithdraw(3000);
        System.out.println(srn.getCustomerBalance());
        System.out.println("Interest at 10%");
        System.out.println(srn.calculateInterest());
    }
}

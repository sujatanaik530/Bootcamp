package com.Banking;

import java.util.Date;

public class SavingsAccount extends Account {
    private final double MINIMUMBALANCE = 10000.00;

    public SavingsAccount() {
    }

    public SavingsAccount(String cName, int cSSN, String cAddress, Date cDateCreated, int cAccountNumber) {
        super(cName, cSSN, cAddress, cDateCreated, cAccountNumber);
    }

    public double getMINIMUMBALANCE() {
        return this.MINIMUMBALANCE;
    }

    @Override
    public void withdrawMoney(double amount) {
        if (cAccountBalance - amount > MINIMUMBALANCE) {
            super.withdrawMoney(amount);
            System.out.println("Withdrew " + amount);
            System.out.println("Your account balance is now " + cAccountBalance);
        }
        else {
            System.out.println("Withdraw not allowed.");
            System.out.println("Withdrawing " + amount + " will take your account balance below the required minimum balance of " + getMINIMUMBALANCE());
        }
    }
}

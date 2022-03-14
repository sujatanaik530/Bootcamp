package com.Banking;

import java.util.Date;

public class Account {
    protected String cName;
    protected int cSSN;
    protected String cAddress;
    protected final String cBankName = "Bank of America";
    protected final String cBankAddress = "Address Line 1, Address Line 2";
    protected final long bRoutingNumber = 123456789000L;
    protected int cAccountNumber;
    protected double cAccountBalance;
    protected final double cAnnualFeesRate = 0.01;
    protected final double cInterestRate = 0.10;
    protected final double cTaxRate = 0.30;
    protected Date cDateCreated;

    public Account() {
    }

    public Account(String cName, int cSSN, String cAddress, Date cDateCreated, int cAccountNumber) {
        this.cName = cName;
        this.cSSN = cSSN;
        this.cAddress = cAddress;
        this.cDateCreated = cDateCreated;
        this.cAccountNumber = cAccountNumber;
    }

    public void withdrawMoney(double amount) {
        this.cAccountBalance -= amount;
    }

    public void depositMoney(double amount) {
        this.cAccountBalance += amount;
        System.out.println();
    }

    public double getAccountBalance() {
        return this.cAccountBalance;
    }

    public double getAmountDue() {
        return this.cAccountBalance * this.cAnnualFeesRate;
    }

    public double getInterestEarned() {
        return this.cAccountBalance * this.cInterestRate;
    }

    public double getTaxesPaid() {
        return this.cAccountBalance * this.cTaxRate;
    }
}

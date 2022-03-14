package com.Banking;

import java.util.Date;

public class CreditCardAccount extends Account {
    private final double CREDITLIMIT = 2000.00;

    public CreditCardAccount() {
    }

    public CreditCardAccount(String cName, int cSSN, String cAddress, Date cDateCreated, int cAccountNumber) {
        super(cName, cSSN, cAddress, cDateCreated, cAccountNumber);
    }

    public double getCREDITLIMIT() {
        return this.CREDITLIMIT;
    }
}

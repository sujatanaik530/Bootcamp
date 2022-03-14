package com.Banking;

import java.util.Date;

public class PrivilegesAccount extends Account {
    public PrivilegesAccount() {
    }
    public PrivilegesAccount(String cName, int cSSN, String cAddress, Date cDateCreated, int cAccountNumber) {
        super(cName, cSSN, cAddress, cDateCreated, cAccountNumber);
    }
}

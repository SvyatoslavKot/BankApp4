package com.company.builder;

import com.company.bankOffice.Kassa;
import com.company.bankOffice.accountManagementDepartment.AccountManeger;
import com.company.bankOffice.creditDepartment.CreditManager;

public class BankOfficeBuilder implements BankBuilder{

    private final AccountManeger accountManager = new AccountManeger();
    private final Kassa kassa = new Kassa();
    private final CreditManager creditManager = new CreditManager();

    public AccountManeger getAccountManager() {
        return accountManager;
    }

    public Kassa getKassa() {
        return kassa;
    }

    public CreditManager getCreditManager() {
        return creditManager;
    }
}

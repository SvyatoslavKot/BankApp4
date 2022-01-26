package com.company.bankOffice.accountManagementDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;

public abstract class DebitAccount {
    private String nameAccount;
    private String accountNumber;
    private int moneyInAccount;
    private String openingDate;
    private int Term;

    abstract void openDebitAccount(Client client, BankOffice bankOffice);
}
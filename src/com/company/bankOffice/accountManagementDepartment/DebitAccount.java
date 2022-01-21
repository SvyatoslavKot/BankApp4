package com.company.bankOffice.accountManagementDepartment;

import com.company.Client;

public abstract class DebitAccount {
    private String nameAccount;
    private String accountNumber;
    private int moneyInAccount;
    private String openingDate;
    private int Term;

    abstract void openDebitAccount(Client client, String nameAccount, int moneyInAccount, int term);
}
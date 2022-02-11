package com.company.bankOffice.accountManagementDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;

public abstract class AccountMoneyModel {


    abstract void openDebitAccount(String nameCredit,int sum,int term, Client client, BankOffice bankOffice, int payment, double cashBack);
}
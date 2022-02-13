package com.company.bank.bankOffice.accountManagementDepartment;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

public abstract class AccountMoneyModel {


    abstract void openDebitAccount(String nameCredit,int sum,int term, Client client, BankOffice bankOffice, int payment, double cashBack);
}
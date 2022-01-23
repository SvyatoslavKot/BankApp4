package com.company.bankOffice.accountManagementDepartment;

import com.company.Client;
import com.company.bankOffice.Staff;

public class AccountManeger  extends Staff {
    public AccountManeger(String name, int age, String position, DebitAccountModel debitAccount) {
        super(name, age, position);
        this.debitAccount = debitAccount;
    }

    private DebitAccountModel debitAccount = new DebitAccountModel();

    public DebitAccountModel getDebitAccount(Client client) {
        System.out.println("Принята заявка на оформление банковского счёта от клиента " + client.getLastName()  + " " + client.getName());
        return debitAccount;
    }



}
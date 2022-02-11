package com.company.bankOffice.accountManagementDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class AccountManagerDepartment {
    BankOffice bankOffice;
    public AccountManagerDepartment (BankOffice bankOffice){
        this.bankOffice = bankOffice;
    }

    ArrayList<AccountManeger> accountPersonal = new ArrayList<>() {
        {
            add(new AccountManeger("Игорь", 26, "Менеджер по работе со счетами"));
        }
    };
    ArrayDeque<String> tickets  =new ArrayDeque<>();
    public AccountManagerDepartment startWork (){
        while (tickets.size()!=0){
                Client client = bankOffice.getBankCollections().clientHashMap.get(tickets.pollFirst());
                AccountMoneyController debitOpenAccount = new AccountMoneyController();
                debitOpenAccount.openDebit(client, bankOffice);
                System.out.println(client.getName());
        }
        return null;
    }

    public ArrayList<AccountManeger> getAccountPersonal() {
        return accountPersonal;
    }


    public ArrayDeque<String> getTickets() {
        return tickets;
    }
}

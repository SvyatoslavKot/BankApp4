package com.company.bankOffice.accountManagementDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.creditDepartment.CreditAccount;
import com.company.bankOffice.creditDepartment.CreditManager;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

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
    public AccountManagerDepartment startWork (BankOffice bankOffice){
        if (tickets.size()!=0){
            for (int i = 0;i < tickets.size(); i++ ){
                Client client = bankOffice.getBankCollections().clientHashMap.get(tickets.pollLast());
                DebitOpenAccount debitOpenAccount = new DebitOpenAccount();
                debitOpenAccount.openDebit(client, bankOffice);
                System.out.println(client.getName());
            }
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

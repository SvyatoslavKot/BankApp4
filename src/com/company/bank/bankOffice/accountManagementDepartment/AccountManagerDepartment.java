package com.company.bank.bankOffice.accountManagementDepartment;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.Ticket;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class AccountManagerDepartment {
    BankOffice bankOffice;
    public AccountManagerDepartment (BankOffice bankOffice){
        this.bankOffice = bankOffice;
    }

    ArrayList<AccountManeger> accountPersonal = new ArrayList<AccountManeger>() {
        {
            add(new AccountManeger("Игорь", 26, "Менеджер по работе со счетами", 66," "));
        }
    };
    ArrayDeque<String> tickets  =new ArrayDeque<>();
    private LinkedList<Ticket> tickets2 = new LinkedList<>();

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

    public LinkedList<Ticket> getTickets2() {
        return tickets2;
    }
}

package com.company.bank.bankOffice.creditDepartment;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.Ticket;

import java.util.*;

public class CreditDepartment{
    BankOffice bankOffice;

    public CreditDepartment(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }
    ArrayList<CreditManager> creditPersonal = new ArrayList<CreditManager>() {
        {
            add(new CreditManager("Олег",22,"Стажер",44, " "));
        }
    };
    private LinkedList<Ticket> tickets2 = new LinkedList<>();

    private ArrayDeque<String> tickets  = new ArrayDeque<>();
   public Client startWork  (){
        while (tickets2.size()!=0) {
                Client client = bankOffice.getBankCollections().getClientHashMap().get(tickets2.pollFirst().getClintId());
                return client;
        }return null;
    }
    public ArrayList<CreditManager> getCreditPersonal() {
        return creditPersonal;
    }
    public ArrayDeque<String> getTickets() {
        return tickets;
    }

    public LinkedList<Ticket> getTickets2() {
        return tickets2;
    }
}




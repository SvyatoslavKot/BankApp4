package com.company.bank.bankOffice.bankFactory.insuranceDepartment;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.Ticket;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class InsuranceDepartment {
    BankOffice bankOffice;

    public InsuranceDepartment(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    ArrayList<InsuranceAgent> insuranceAgents = new ArrayList<InsuranceAgent>() {
        {
            add(new InsuranceAgent(" Игорь" , 33, "Страховой Агент", 44, " "));
        }
    };

    private LinkedList<Ticket> tickets2 = new LinkedList<>();
    ArrayDeque<String> tickets  = new ArrayDeque<>();

    public Client startWork (){
        while (tickets2.size()!=0){
                Client client = bankOffice.getBankCollections().getClientHashMap().get(tickets2.pollFirst().getClintId());
                return client;
        }
        return null;
    }

    public ArrayList<InsuranceAgent> getInsuranceAgents() {
        return insuranceAgents;
    }
    public ArrayDeque<String> getTickets() {
        return tickets;
    }

    public LinkedList<Ticket> getTickets2() {
        return tickets2;
    }
}

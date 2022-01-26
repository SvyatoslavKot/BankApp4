package com.company.bankOffice.creditDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.Staff;
import com.company.bankOffice.Ticket;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.PriorityQueue;

public class CreditDepartment  {
    ArrayList<CreditManager> creditPersonal = new ArrayList<>() {
        {
            add(new CreditManager("Олег",22,"Стажер"));
        }
    };
    PriorityQueue<Client> clients = new PriorityQueue<>();
    PriorityQueue<String> tickets  = new PriorityQueue<>();

    public CreditAccount startWork (BankOffice bankOffice){
        if (tickets.size()!=0){
            for (int i = 0;i <= tickets.size(); i++ ) {
                Client client = clientById(tickets.poll());
                CreditAccount creditAccount = new CreditAccount();
                creditAccount.openCredit(client, bankOffice);
                System.out.println(client.getName());
            }
        }
        return null;
    }

    private Client clientById(String id){
        for(Client currentClient : clients){
            if(currentClient != null && currentClient.getId().equals(id))
                return currentClient;
        }
        return  null;
    }

    public ArrayList<CreditManager> getCreditPersonal() {
        return creditPersonal;
    }

    public PriorityQueue<Client> getClients() {
        return clients;
    }

    public PriorityQueue<String> getTickets() {
        return tickets;
    }
}

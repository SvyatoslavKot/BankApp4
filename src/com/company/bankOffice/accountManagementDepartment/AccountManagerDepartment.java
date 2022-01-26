package com.company.bankOffice.accountManagementDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.creditDepartment.CreditAccount;
import com.company.bankOffice.creditDepartment.CreditManager;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AccountManagerDepartment {
    ArrayList<AccountManeger> accountPersonal = new ArrayList<>() {
        {
            add(new AccountManeger("Игорь", 26, "Менеджер по работе со счетами"));
        }
    };

    PriorityQueue<Client> clients = new PriorityQueue<>();
    PriorityQueue<String> tickets  =new PriorityQueue<>();

    public AccountManagerDepartment startWork (BankOffice bankOffice){
        if (tickets.size()!=0){
            for (int i = 0;i <= tickets.size(); i++ ){
                Client client = clientById(tickets.poll());
                DebitAccountModel debitAccountModel = new DebitAccountModel();
                debitAccountModel.openDebitAccount(client,bankOffice);
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

    public ArrayList<AccountManeger> getAccountPersonal() {
        return accountPersonal;
    }

    public PriorityQueue<Client> getClients() {
        return clients;
    }

    public PriorityQueue<String> getTickets() {
        return tickets;
    }
}

package com.company.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.accountManagementDepartment.AccountManeger;
import com.company.bankOffice.creditDepartment.CreditAccount;
import com.company.bankOffice.creditDepartment.CreditManager;
import com.company.service.WaitingInLine;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class InsuranceDepartment {
    ArrayList<InsuranceAgent> insuranceAgents = new ArrayList<>() {
        {
            add(new InsuranceAgent(" Игорь" , 33, "Страховой Агент"));
        }
    };
    PriorityQueue<Client> clients = new PriorityQueue<>();
    PriorityQueue<String> tickets  =new PriorityQueue<>();

    public InsuranceDepartment startWork (BankOffice bankOffice){
        if (tickets.size()!= 0){
            for (int i = 0;i <= tickets.size(); i++ ){
                Client client = clientById(tickets.poll());
                Insurance insurance = new Insurance();
                insurance.openInsuranceType1();
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

    public ArrayList<InsuranceAgent> getInsuranceAgents() {
        return insuranceAgents;
    }

    public PriorityQueue<Client> getClients() {
        return clients;
    }

    public PriorityQueue<String> getTickets() {
        return tickets;
    }
}

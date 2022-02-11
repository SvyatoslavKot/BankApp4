package com.company.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class InsuranceDepartment {
    BankOffice bankOffice;

    public InsuranceDepartment(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    ArrayList<InsuranceAgent> insuranceAgents = new ArrayList<>() {
        {
            add(new InsuranceAgent(" Игорь" , 33, "Страховой Агент"));
        }
    };
    ArrayDeque<String> tickets  = new ArrayDeque<>();

    public InsuranceOpen startWork (){
        while (tickets.size()!=0){
                Client client = bankOffice.getBankCollections().getClientHashMap().get(tickets.pollFirst());
                InsuranceOpen insuranceOpen = new InsuranceOpen();
                insuranceOpen.openInsurance(client, bankOffice);
        }
        return null;
    }

    public ArrayList<InsuranceAgent> getInsuranceAgents() {
        return insuranceAgents;
    }
    public ArrayDeque<String> getTickets() {
        return tickets;
    }
}

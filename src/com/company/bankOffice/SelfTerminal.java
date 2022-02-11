package com.company.bankOffice;

import com.company.Client;
import com.company.bankCentralOffice.BankCentralOffice;
import com.company.bankCentralOffice.ManagerCustomerService;
import com.company.bankCentralOffice.ManagerSpecialAccountOperations;
import com.company.bankOffice.accountManagementDepartment.AccountManagerDepartment;
import com.company.bankOffice.accountManagementDepartment.AccountManeger;
import com.company.bankOffice.creditDepartment.CreditDepartment;
import com.company.bankOffice.creditDepartment.CreditManager;
import com.company.bankOffice.insuranceDepartment.InsuranceAgent;
import com.company.bankOffice.insuranceDepartment.InsuranceDepartment;

public class SelfTerminal {
    int counter;
    public String getTicketToCredit (Client client, BankOffice bankOffice){
        counter = counter + 1;
        String numberOfTikcet = "C-"+ counter;
        bankOffice.getBankCollections().getClientHashMap().put(client.getId(),client);
        bankOffice.getCreditDepartment().getTickets().addLast(client.getId());
        System.out.println("Создан клиент с талонном: " + numberOfTikcet);
       return numberOfTikcet;
    }
    public String getTicketToAccount (Client client, BankOffice bankOffice){
        counter = counter + 1;
        String numberOfTikcet = "A-"+ counter;
        bankOffice.getBankCollections().getClientHashMap().put(client.getId(),client);
        bankOffice.getAccountManagerDepartment().getTickets().addLast(client.getId());
        System.out.println("Создан клиент с талонном: " + numberOfTikcet);
        return numberOfTikcet;
    }
    public String getTicketToInsurance (Client client, BankOffice bankOffice){
        counter = counter + 1;
        String numberOfTikcet = "I-"+ counter;
        bankOffice.getBankCollections().getClientHashMap().put(client.getId(),client);
        bankOffice.getInsuranceDepartment().getTickets().addLast(client.getId());
        System.out.println("Создан клиент с талонном: " + numberOfTikcet);
        return numberOfTikcet;
    }



}


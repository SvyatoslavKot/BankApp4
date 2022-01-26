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

    public String getTicketToCredit (Client client, CreditDepartment creditDepartment){
        String numberOfTikcet = "C-"+ creditDepartment.getTickets().size();
        creditDepartment.getClients().add(client);
        creditDepartment.getTickets().add(client.getId());
        System.out.println("Создан клиент с талонном: " + numberOfTikcet);
       return numberOfTikcet;
    }
    public String getTicketToAccount (Client client, AccountManagerDepartment accountDepartment){
        String numberOfTikcet = "A-"+ accountDepartment.getTickets().size();
        accountDepartment.getClients().add(client);
        accountDepartment.getTickets().add(client.getId());
        System.out.println("Создан клиент с талонном: " + numberOfTikcet);
        return numberOfTikcet;
    }
    public String getTicketToInsurance (Client client, InsuranceDepartment insuranceDepartment){
        String numberOfTikcet = "I-"+ insuranceDepartment.getTickets().size();
        insuranceDepartment.getClients().add(client);
        insuranceDepartment.getTickets().add(client.getId());
        System.out.println("Создан клиент с талонном: " + numberOfTikcet);
        return numberOfTikcet;
    }



}


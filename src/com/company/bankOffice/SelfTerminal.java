package com.company.bankOffice;

import com.company.Client;
import com.company.bankCentralOffice.BankCentralOffice;
import com.company.bankCentralOffice.ManagerCustomerService;
import com.company.bankCentralOffice.ManagerSpecialAccountOperations;
import com.company.bankOffice.accountManagementDepartment.AccountManeger;
import com.company.bankOffice.creditDepartment.CreditDepartment;
import com.company.bankOffice.creditDepartment.CreditManager;
import com.company.bankOffice.insuranceDepartment.InsuranceAgent;

public class SelfTerminal {
    //private AccountManeger accountManager = new AccountManeger();
    //private CreditManager creditManager = new CreditManager();
    //private InsuranceAgent insuranceAgent = new InsuranceAgent();
    //private ManagerCustomerService customerServiceDepartment = new ManagerCustomerService();
    //private ManagerSpecialAccountOperations specialAccountOperations = new ManagerSpecialAccountOperations();

    private CreditDepartment creditDepartment = new CreditDepartment();

    public CreditDepartment getCreditDepartment() {
        return creditDepartment;
    }

    // WaitingInLine waitingInLine = new WaitingInLine();

   /* public AccountManeger getAccountManagement(Client client) {
        System.out.println("Клиент " + client.getName() +  " перенаправлен в отдел управления счетами.");
        return accountManager;
    }
    public CreditManager getCreditManager(Client client) {
        // waitingInLine.waitingInLine(client.getName());
        System.out.println("Подойти к менеджеру по кредитам.");
        return creditManager;

    }

    public InsuranceAgent getInsuranceAgent(Client client) {
        System.out.println("Клиент " + client.getName() +  " перенаправлен в отдел страхованния.");
        return insuranceAgent;
    }

    public ManagerCustomerService getManegerCustomService(Client client, BankCentralOffice bankCentralOffice) {
        System.out.println(client.getName() + " обратился в отдел по работе с клиентами в " + bankCentralOffice.getNameBank());
        //waitingInLine.waitingInLine(client.getName());
        return customerServiceDepartment;
    }
    public ManagerSpecialAccountOperations getSpecialAccountOperations(Client client, BankCentralOffice bankCentralOffice) {
        System.out.println(client.getName() + " обратился в отдел по работе со специфическими счётами в "+ bankCentralOffice.getNameBank());
        // waitingInLine.waitingInLine(client.getName());
        return specialAccountOperations;
    }*/
}


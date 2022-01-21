package com.company.bankOffice;

import com.company.Client;
import com.company.bankCentralOffice.BankCentralOffice;
import com.company.bankCentralOffice.ManagerCustomerService;
import com.company.bankCentralOffice.ManagerSpecialAccountOperations;
import com.company.bankOffice.accountManagementDepartment.AccountManeger;
import com.company.bankOffice.creditDepartment.CreditManager;

public class SelfTerminal {
    private AccountManeger accountManager = new AccountManeger();
    private ManagerCustomerService customerServiceDepartment = new ManagerCustomerService();
    private ManagerSpecialAccountOperations specialAccountOperations = new ManagerSpecialAccountOperations();
    private Kassa kassa = new Kassa();
    private CreditManager creditManager = new CreditManager();
    // WaitingInLine waitingInLine = new WaitingInLine();

    public AccountManeger getAccountManagement(Client client) {
        System.out.println("Клиент " + client.getName() +  " перенаправлен в отдел управления счетами.");
        return accountManager;
    }
    public CreditManager getCreditManager(Client client) {
        // waitingInLine.waitingInLine(client.getName());
        System.out.println("Подойти к менеджеру по кредитам.");
        return creditManager;

    }
    public Kassa getKassa(Client client) {
        System.out.println("Клиент"+ client.getName() + " направлен в кассу.");
        return kassa;
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
    }
}


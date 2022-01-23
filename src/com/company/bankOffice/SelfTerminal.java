package com.company.bankOffice;

import com.company.Client;
import com.company.bankCentralOffice.BankCentralOffice;
import com.company.bankCentralOffice.ManagerCustomerService;
import com.company.bankCentralOffice.ManagerSpecialAccountOperations;
import com.company.bankOffice.accountManagementDepartment.AccountManeger;
import com.company.bankOffice.creditDepartment.CreditManager;
import com.company.builder.BankBuilder;

public class SelfTerminal {

    private BankBuilder bankBuilder;
    // WaitingInLine waitingInLine = new WaitingInLine();

    public AccountManeger getAccountManagement(Client client) {
        System.out.println("Клиент " + client.getName() +  " перенаправлен в отдел управления счетами.");
        return bankBuilder.getAccountManager();
    }
    public CreditManager getCreditManager(Client client) {
        // waitingInLine.waitingInLine(client.getName());
        System.out.println("Подойти к менеджеру по кредитам.");
        return bankBuilder.getCreditManager();

    }
    public Kassa getKassa(Client client) {
        System.out.println("Клиент"+ client.getName() + " направлен в кассу.");
        return bankBuilder.getKassa();
    }
    public ManagerCustomerService getManagerCustomService(Client client, BankCentralOffice bankCentralOffice) {
        System.out.println(client.getName() + " обратился в отдел по работе с клиентами в " + bankCentralOffice.getNameBank());
        //waitingInLine.waitingInLine(client.getName());
        return bankBuilder.getCustomerServiceDepartment();
    }
    public ManagerSpecialAccountOperations getSpecialAccountOperations(Client client, BankCentralOffice bankCentralOffice) {
        System.out.println(client.getName() + " обратился в отдел по работе со специфическими счётами в "+ bankCentralOffice.getNameBank());
        // waitingInLine.waitingInLine(client.getName());
        return bankBuilder.getSpecialAccountOperations();
    }

    public void setBankBuilder(BankBuilder bankBuilder) {
        this.bankBuilder = bankBuilder;
    }
}


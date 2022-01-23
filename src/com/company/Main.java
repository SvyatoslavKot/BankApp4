package com.company;

import com.company.bankCentralOffice.BankCentralOffice;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.SelfTerminal;
import com.company.bankOffice.creditDepartment.CreditAccount;
import com.company.bankOffice.creditDepartment.CreditManager;
import com.company.bilder.ClientBilder;
import com.company.mobilBank.MobilBank;

public class Main {

    public static void main(String[] args) {
        System.out.println("test Branch");


        Client clientSergei = new Client();
        Client clientAnna = new Client();
        BankOffice bankSber = new BankOffice("Сбербанк");
        BankCentralOffice bankCentralOffice = new BankCentralOffice("Сбербанк");
        MobilBank mobilBank = new MobilBank("Сбербанк");

        ClientBilder clientBilder = new ClientBilder();
       // clientBilder.bildMobilBankChatBot(mobilBank,clientSergei);
        SelfTerminal terminal1 = clientBilder.bildSelfServiceTerminal(bankSber,clientSergei);
        SelfTerminal terminal2 = clientBilder.bildSelfServiceTerminal(bankSber,clientAnna);

        CreditManager creditManager = terminal1.getCreditManager(clientSergei);
        CreditAccount creditAccountSergei = creditManager.getCreditAccount(clientSergei,bankSber);
        creditAccountSergei.openCredit(clientSergei,"Потребительсикй", bankSber);


        bankSber.viewClientList();

        clientSergei.viewCreditAccount();
        clientAnna.viewCreditAccount();
    }
}
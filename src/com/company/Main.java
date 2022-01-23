package com.company;

import com.company.bankCentralOffice.BankCentralOffice;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.SelfTerminal;
import com.company.bankOffice.creditDepartment.CreditAccount;
import com.company.bankOffice.creditDepartment.CreditManager;
import com.company.builder.ClientBuilder;
import com.company.mobilBank.MobilBank;

public class Main {

    public static void main(String[] args) {



        Client clientSergei = new Client();
        Client clientAnna = new Client();
        BankOffice bankSber = new BankOffice("Сбербанк");
        BankCentralOffice bankCentralOffice = new BankCentralOffice("Сбербанк");
        MobilBank mobilBank = new MobilBank("Сбербанк");

        ClientBuilder clientBilder = new ClientBuilder();
        clientBilder.buildMobilBankChatBot(mobilBank,clientSergei);
        SelfTerminal terminal1 = clientBilder.buildSelfServiceTerminal(bankSber,clientSergei);
        SelfTerminal terminal2 = clientBilder.buildSelfServiceTerminal(bankSber,clientAnna);

        CreditManager creditManager = terminal1.getCreditManager(clientSergei);
        CreditAccount creditAccountSergei = creditManager.getCreditAccount(clientSergei,bankSber);
        creditAccountSergei.openCredit(clientSergei,"Потребительсикй", bankSber);
        creditAccountSergei.openCredit(clientSergei,"Ипотека", bankSber);

        CreditManager creditManager2 = terminal2.getCreditManager(clientSergei);
        CreditAccount creditAccountAnna = creditManager2.getCreditAccount(clientSergei,bankSber);

        creditAccountAnna.openCredit(clientAnna, "Автокредит", bankSber);
        creditAccountAnna.openCredit(clientAnna, "Ипотека", bankSber);

        bankSber.viewClientList();

        clientSergei.viewCreditAccount();
        clientAnna.viewCreditAccount();
    }
}
package com.company;

import com.company.bankCentralOffice.BankCentralOffice;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.SelfTerminal;
import com.company.bankOffice.creditDepartment.CreditAccount;
import com.company.bankOffice.creditDepartment.CreditDepartment;
import com.company.bankOffice.creditDepartment.CreditManager;

import com.company.bilder.BankBilder;
import com.company.mobilBank.MobilBank;

public class Main {

    public static void main(String[] args) {



        Client clientSergei = new Client();
        Client clientAnna = new Client();
        BankOffice bankSber = new BankOffice("Сбербанк");
        BankCentralOffice bankCentralOffice = new BankCentralOffice("Сбербанк");
        MobilBank mobilBank = new MobilBank("Сбербанк");
        BankBilder bankBilder = new BankBilder();

        SelfTerminal terminal = bankBilder.bildSelfServiceTerminal(bankSber,clientAnna);
        CreditDepartment creditDepartment = terminal.getCreditDepartment();
        System.out.println("Работает: " + creditDepartment.getCreditPersonal().get(0).getName());

        bankSber.viewClientList();

        clientSergei.viewCreditAccount();
        clientAnna.viewCreditAccount();
    }
}
package com.company.service.Parser;

import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;

import java.io.IOException;

//test class

public class Start {
    public static void main(String[] args) throws IOException, InterruptedException {
        BankOffice bankOffice = MainFxml.getBankOffice();
        ParserCurrency parserCurrency = new ParserCurrency(bankOffice);

        parserCurrency.start();
        Thread t = Thread.currentThread();
        t.sleep(6000);
        System.out.println(bankOffice.getBankCollections().getCurrencyCBR().size());
    }
}

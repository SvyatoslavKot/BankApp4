package com.company;

import com.company.bank.bankCentralOffice.BankCentralOffice;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.mobilBank.MobilBank;

public class Main {
      BankOffice bankOffice = new BankOffice("jj");

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public static void main(String[] args) {
       // BdWriteClient bdWriteClient = new BdWriteClient();
        //BdReadClient bdReadClient = new BdReadClient();

        BankOffice bankSber = new BankOffice("Sber");





        Client clientSergei = new Client("Сергей "," ", 22,"23",50000,500000,"7676 875434");
        Client clientAnna = new Client("Anna "," ", 22,"28",52000,540000,"7676 434234");
        Client clientOlga = new Client("Olga "," ", 22,"441",44000,505500,"7676 85652");
        Client clientEgor = new Client("Egor "," ", 22,"431",45000,505600,"7676 42414");
        Client clientUriy = new Client("Ura "," ", 22,"491",49000,500600,"7676 09843");





        Client client = bankSber.getBankCollections().getClientHashMap().get("2");
        System.out.println(client.getName());
        MobilBank mobilBankSber = new MobilBank(bankSber);

        BankCentralOffice bankCentralOffice = new BankCentralOffice("Sber");


    }


}
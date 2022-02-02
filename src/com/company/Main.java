package com.company;

import com.company.bankCentralOffice.BankCentralOffice;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.insuranceDepartment.InsuranceAgent;
import com.company.bankOffice.insuranceDepartment.InsuranceOpen;
import com.company.mobilBank.MobilBank;

public class Main {


    public static void main(String[] args) {

        Client clientSergei = new Client("Сергей ","23",50000,500000,"7676 875434");
        Client clientAnna = new Client("Anna ","28",52000,540000,"7676 434234");
        Client clientOlga = new Client("Olga ","441",44000,505500,"7676 85652");
        Client clientEgor = new Client("Egor ","431",45000,505600,"7676 42414");
        Client clientUriy = new Client("Ura ","491",49000,500600,"7676 09843");

        BankOffice bankSber = new BankOffice("Sber");
        MobilBank mobilBankSber = new MobilBank(bankSber);
        BankCentralOffice bankCentralOffice = new BankCentralOffice("Sber");

        String tic1 = bankSber.getTerminal1().getTicketToAccount(clientSergei,bankSber);
        String tic2 = bankSber.getTerminal1().getTicketToCredit(clientOlga,bankSber);
        String tic3 = bankSber.getTerminal1().getTicketToCredit(clientEgor,bankSber);
        String tic4 = bankSber.getTerminal1().getTicketToAccount(clientUriy,bankSber);
        String tic5 = bankSber.getTerminal1().getTicketToInsurance(clientSergei,bankSber);
        String tic6 = bankSber.getTerminal1().getTicketToInsurance(clientSergei,bankSber);
        bankSber.getInsuranceDepartment().startWork();
        bankSber.getAccountManagerDepartment().startWork();
        bankSber.getCreditDepartment().startWork();

        InsuranceAgent agent = bankSber.getInsuranceDepartment().getInsuranceAgents().get(0);

        bankSber.getBankCollections().sourceInsurence(clientSergei);

    }

}
package com.company;

import com.company.bankCentralOffice.BankCentralOffice;
import com.company.bankOffice.BankOffice;
import com.company.mobilBank.MobilBank;

public class Main {


    public static void main(String[] args) {

        Client clientSergei = new Client("Сергей ","23",50000,500000,"7676 875434");
        Client clientAnna = new Client("Anna ","28",52000,540000,"7676 434234");
        Client clientOlga = new Client("Olga ","441",44000,505500,"7676 85652");
        Client clientEgor = new Client("Egor ","431",45000,505600,"7676 42414");

        BankOffice bankSber = new BankOffice("Sber");
        MobilBank mobilBankSber = new MobilBank(bankSber);
        BankCentralOffice bankCentralOffice = new BankCentralOffice("Sber");
        String tic = bankCentralOffice.getTerminal1().getTicketToInsurance(clientAnna,bankCentralOffice.getInsuranceDepartment());



        String tikeckSergei = bankSber.getTerminal1().getTicketToCredit(clientAnna,bankSber.getCreditDepartment());
        String tikeckAnna = bankSber.getTerminal2().getTicketToCredit(clientAnna,bankSber.getCreditDepartment());
        String tikeckOlga = bankSber.getTerminal1().getTicketToCredit(clientOlga,bankSber.getCreditDepartment());
        String ticketOlga2 = bankSber.getTerminal2().getTicketToAccount(clientOlga,bankSber.getAccountManagerDepartment());
        String tic1 = bankSber.getTerminal1().getTicketToInsurance(clientEgor,bankSber.getInsuranceDepartment());
        String tic2 = bankSber.getTerminal2().getTicketToCredit(clientSergei,bankSber.getCreditDepartment());


        bankSber.getCreditDepartment().startWork(bankSber);
        bankSber.getCreditDepartment().startWork(bankSber);
        bankSber.getCreditDepartment().startWork(bankSber);
        bankSber.getCreditDepartment().startWork(bankSber);

        mobilBankSber.openMobilBankChatBot();




    }

}
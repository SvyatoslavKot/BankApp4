package com.company.bank.bankOffice;

public class SelfTerminal {
    int counter;
    public String getTicketToCredit (String id, BankOffice bankOffice){
        counter = counter + 1;
        String numberOfTikcet = "C-"+ counter;
        bankOffice.getBankCollections().getClientHashMap().get(id);
        bankOffice.getCreditDepartment().getTickets2().addLast(new Ticket(numberOfTikcet, id));
        System.out.println("создан талон " + numberOfTikcet);
       return numberOfTikcet;
    }
    public String getTicketToAccount (String id, BankOffice bankOffice){
        counter = counter + 1;
        String numberOfTikcet = "A-"+ counter;
        bankOffice.getBankCollections().getClientHashMap().get(id);
        bankOffice.getAccountManagerDepartment().getTickets2().addLast(new Ticket(numberOfTikcet, id));
        System.out.println("создан талон " + numberOfTikcet);
        return numberOfTikcet;
    }
    public String getTicketToInsurance (String id, BankOffice bankOffice){
        counter = counter + 1;
        String numberOfTikcet = "I-"+ counter;
        bankOffice.getBankCollections().getClientHashMap().get(id);
        bankOffice.getInsuranceDepartment().getTickets2().addLast(new Ticket(numberOfTikcet, id));
        System.out.println("создан талон " + numberOfTikcet);
        return numberOfTikcet;
    }



}


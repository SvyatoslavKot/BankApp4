package com.company.bank.bankOffice;

public class Ticket {
    String numberOfTicket;
    String clintId;

    public Ticket(String numberOfTicket, String clintId) {
        this.numberOfTicket = numberOfTicket;
        this.clintId = clintId;
    }

    public String getNumberOfTicket() {
        return numberOfTicket;
    }

    public String getClintId() {
        return clintId;
    }
}

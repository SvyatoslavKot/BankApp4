package com.company.bankOffice.creditDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;
import java.util.*;

public class CreditDepartment{
    BankOffice bankOffice;

    public CreditDepartment(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }
    ArrayList<CreditManager> creditPersonal = new ArrayList<>() {
        {
            add(new CreditManager("Олег",22,"Стажер"));
        }
    };
   private ArrayDeque<String> tickets  = new ArrayDeque<>();
   public CreditController startWork  (){
        while (tickets.size()!=0) {
                Client client = bankOffice.getBankCollections().getClientHashMap().get(tickets.pollFirst());
                CreditController creditAccount = new CreditController();
                creditAccount.openCredit(client, bankOffice);
        }
        return null;
    }
    public ArrayList<CreditManager> getCreditPersonal() {
        return creditPersonal;
    }
    public ArrayDeque<String> getTickets() {
        return tickets;
    }

}




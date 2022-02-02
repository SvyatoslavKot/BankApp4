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
   public CreditAccount startWork  (){
        if (tickets.size()!=0){
            for (int i = 0;i < tickets.size();i++) {
                Client client = bankOffice.getBankCollections().getClientHashMap().get(tickets.pollLast());
                CreditAccount creditAccount = new CreditAccount();
                creditAccount.openCredit(client, bankOffice);
            }
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




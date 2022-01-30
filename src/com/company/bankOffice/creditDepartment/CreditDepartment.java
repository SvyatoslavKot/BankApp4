package com.company.bankOffice.creditDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.Staff;
import com.company.bankOffice.Ticket;

import javax.sound.midi.Track;
import java.util.*;

public class CreditDepartment extends Thread {


    BankOffice bankOffice;
    Random rnd;

    public CreditDepartment(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }
    ArrayList<CreditManager> creditPersonal = new ArrayList<>() {
        {
            add(new CreditManager("Олег",22,"Стажер"));
        }
    };
   private PriorityQueue<Client> clients = new PriorityQueue<>();
   private ArrayList<String> tickets  = new ArrayList<>();

   /*public CreditAccount startWork  (){
        if (tickets.size()!=0){
            for (int i = 0;i < tickets.size();i++) {
                Client client = clientById(tickets.get(i));
                CreditAccount creditAccount = new CreditAccount();
                creditAccount.openCredit(client, bankOffice);
            }
        }
        return null;
    }*/
   @Override
   public synchronized void run() {
           if (tickets.size()!=0){
               for (int i = 0;i < tickets.size();i++) {
               try { wait(1000);
               }catch (InterruptedException e) {
                   e.printStackTrace();
               }
               Client client = clientById(tickets.get(i));
               CreditAccount creditAccount = new CreditAccount();
               creditAccount.openCredit(client, bankOffice);
                   System.out.println(

                           creditPersonal.get((int) (Math.random() * getCreditPersonal().size() - 1)).getPosition()+ " "+
                                   creditPersonal.get((int) (Math.random() * getCreditPersonal().size() - 1)).getName()+
                                   " обслуживает клиента");
           }
           }
   }

    private Client clientById(String id){
        for(Client currentClient : clients){
            if(currentClient != null && currentClient.getId().equals(id))
                return currentClient;
        }
        return  null;
    }

    public ArrayList<CreditManager> getCreditPersonal() {
        return creditPersonal;
    }

    public PriorityQueue<Client> getClients() {
        return clients;
    }

    public ArrayList<String> getTickets() {
        return tickets;
    }

}




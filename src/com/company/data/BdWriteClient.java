package com.company.data;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BdWriteClient {
    private String CLIENT_MAPA = "com.company.BD_Bank.clients.txt";
    Client client;
    public void writeClient (BankOffice bankOffice, String fileBD){
        try (FileWriter fw = new FileWriter(fileBD)){
            fw.write("");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String,Client> clientHashMap = bankOffice.getBankCollections().getClientHashMap();
        for (Map.Entry entry: clientHashMap.entrySet()){
         client = (Client) entry.getValue();
         try (FileWriter fileWriter  =new FileWriter(fileBD, true)) {

             fileWriter.write("name:"+client.getName()+" ");
             fileWriter.write("lastnam:"+client.getLastName()+" ");
             fileWriter.write("pasport:"+client.getPassport()+" ");
             fileWriter.write("age:"+client.getAge()+" ");
             fileWriter.write("income:"+client.getIncome()+" ");
             fileWriter.write("cash:"+client.getCash()+" ");
             fileWriter.write("id:"+client.getId()+" ");
             fileWriter.write("\n");

             fileWriter.flush();

         } catch (IOException e) {
             e.printStackTrace();
         }
        }
    }
}

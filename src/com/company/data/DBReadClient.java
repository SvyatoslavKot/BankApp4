package com.company.data;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DBReadClient {
    private static DBReadClient dbClient;

    private DBReadClient() {
    }

    public static DBReadClient getInstance(){
        if (dbClient == null) {
            dbClient = new DBReadClient();
        }
        return dbClient;
    }

    HashMap<String, Client> clientHashMap = new HashMap<>();
    Client client;
    public  void readBD (BankOffice bankOffice, String filebd){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filebd))) {
            String currentLine = " ";
            while (null != (currentLine = bufferedReader.readLine())) {
                client = convertStringToClient(currentLine);
                clientHashMap.put(client.getId(), client);

            }
            bankOffice.getBankCollections().getClientHashMap().putAll(clientHashMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Client convertStringToClient ( String currentLine){
        String[] sp = currentLine.split(" ");
        Client client1 = new Client();
        for (String s : sp){

            getIdandSet(s,client1);
            getPasAndSet(s,client1);
            getNameAndSet(s,client1);
            getLastNameAndSet(s,client1);
            getAgeAndSet(s,client1);
            getIncomAndSet(s,client1);
            getCashAndSet(s,client1);
        }
        return client1;
    }

    private void getCashAndSet(String s, Client client1) {
        if ( s!= null && s.contains("cash:")){
            client1.setCash(Integer.valueOf(s.split(":")[1]));
        }
    }

    private void getIncomAndSet(String s, Client client1) {
        if ( s!= null && s.contains("income:")){
            client1.setIncome(Integer.valueOf(s.split(":")[1]));
        }
    }

    private void getAgeAndSet(String s, Client client1) {
        if ( s!= null && s.contains("age:")){
            client1.setAge(Integer.valueOf(s.split(":")[1]));
        }
    }

    private void getLastNameAndSet(String s, Client client1) {
        if ( s!= null && s.contains("lastNam:")){
            client1.setLastName(s.split(":")[1]);
        }
    }

    private void getPasAndSet(String s, Client client1) {
        if ( s!= null && s.contains("pasport:")){
            client1.setPassport(s.split(":")[1]);
        }
    }

    private void getIdandSet(String s, Client client1) {
        if ( s!= null && s.contains("id:")){
            client1.setId(s.split(":")[1]);
        }
    }

    public  void getNameAndSet(String s, Client client1){
        if ( s!= null && s.contains("name:")){
            client1.setName(s.split(":")[1]);
        }
    }

}

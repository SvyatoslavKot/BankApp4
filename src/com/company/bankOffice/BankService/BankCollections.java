package com.company.bankOffice.BankService;

import com.company.Client;

import java.util.HashMap;


public class BankCollections {
    public HashMap<String, Client> clientHashMap = new HashMap<>();

    public HashMap<String, Client> getClientHashMap() {
        return clientHashMap;
    }


}

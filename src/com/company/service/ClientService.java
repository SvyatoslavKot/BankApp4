package com.company.service;

import com.company.Client;

public class ClientService {
    public int giveCash(int money, Client client){
        int a = 0;
        if(client.getCash()>= money){
            a = client.getCash() - money;
            client.setCash(a);
            return client.getCash();
        }else {
            System.out.println("Недостаточно денег в кошельке");
        }
        return client.getCash();
    }

    public void takeCash(int money, Client client) {
        int a = 0;
        a = client.getCash() + money;
        client.setCash(a);

    }
}
package com.company.service;

import com.company.Client;

import java.io.Serializable;
import java.util.HashMap;

public class ClientCollection implements Serializable {
    HashMap<String,Client> clientBD = new HashMap<String, Client>(){{
        put("1",new Client("Сергей"," ", 22,"1",50000,500000,"7676875434"));
        put("2",new Client("Анна"," ", 22,"2",50000,500000,"76762434523"));
        put("3",new Client("Генадий"," ", 22,"3",50000,500000,"7633564982"));
        put("4",new Client("Валерий"," ", 22,"4",50000,500000,"7614824057"));
        put("5",new Client("Юлия"," ", 22,"5",50000,500000,"7699245342"));
        put("6",new Client("Василий"," ", 22,"6",50000,500000,"7656754254"));
        put("7",new Client("Мария"," ", 22,"7",50000,500000,"7698532799"));
        put("8",new Client("Евгений"," ", 22,"8",50000,500000,"76982736781"));
        put("9",new Client("Лариса"," ", 22,"9",50000,500000,"767232432"));
        put("10",new Client("Тимофей"," ", 22,"10",50000,500000,"7676875434"));
        put("11",new Client("Гоша"," ", 22,"11",50000,500000,"7676875434"));
        put("12",new Client("Денис"," ", 22,"12",50000,500000,"7676875434"));
        put("13",new Client("Марк"," ", 22,"13",50000,500000,"7676875434"));
        put("14",new Client("Марго"," ", 22,"14",50000,500000,"7676875434"));
        put("15",new Client("Валентин"," ", 22,"15",50000,500000,"7676875434"));
    }};

    public HashMap<String, Client> getClientBD() {
        return clientBD;
    }
}

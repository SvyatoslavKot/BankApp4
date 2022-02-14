package com.company.service;

import com.company.Client;

import java.io.Serializable;
import java.util.HashMap;

public class ClientCollection implements Serializable {
    HashMap<String,Client> clientBD = new HashMap<String, Client>(){{
        put("1",new Client("Сергей ","1",50000,500000,"7676 875434"));
        put("2",new Client("Анна ","2",50000,500000,"7676 2434523"));
        put("3",new Client("Генадий ","3",50000,500000,"7633 564982"));
        put("4",new Client("Валерий ","4",50000,500000,"7614 824057"));
        put("5",new Client("Юлия ","5",50000,500000,"7699 245342"));
        put("6",new Client("Василий ","6",50000,500000,"7656 754254"));
        put("7",new Client("Мария ","7",50000,500000,"7698 532799"));
        put("8",new Client("Евгений ","8",50000,500000,"7698 2736781"));
        put("9",new Client("Лариса ","9",50000,500000,"767232432"));
        put("10",new Client("Тимофей ","10",50000,500000,"7676 875434"));
        put("11",new Client("Гоша ","11",50000,500000,"7676 875434"));
        put("12",new Client("Денис ","12",50000,500000,"7676 875434"));
        put("13",new Client("Марк ","13",50000,500000,"7676 875434"));
        put("14",new Client("Марго ","14",50000,500000,"7676 875434"));
        put("15",new Client("Валентин ","15",50000,500000,"7676 875434"));
    }};

    public HashMap<String, Client> getClientBD() {
        return clientBD;
    }
}

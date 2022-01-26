package com.company.bankOffice.creditDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.Staff;

import java.util.HashMap;

public class CreditManager extends Staff {


    public CreditManager(String name, int age, String position) {
        super(name, age, position);
    }

    HashMap<String,String> informMap = new HashMap<>();

    private CreditAccount creditAccount = new CreditAccount();
    HashMap<String, String> listClientHashMap = new HashMap<>();

    public CreditAccount getCreditAccount(Client client, BankOffice bankOffice) {

        System.out.println("Принята заявка на оформление кредитного счёта в " + bankOffice.getNameBank() + "от клиента " + client.getLastName()  + " " + client.getName());
        return creditAccount;
    }
    }

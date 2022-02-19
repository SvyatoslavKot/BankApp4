package com.company.bank.bankOffice.BankService;

import com.company.Client;
import com.company.bank.bankOffice.accountManagementDepartment.AccountMoney;
import com.company.bank.bankOffice.creditDepartment.Credit;
import com.company.bank.bankOffice.insuranceDepartment.Insurance;
import com.company.service.ClientCollection;

import java.io.Serializable;
import java.util.*;


public class BankCollections  implements Serializable {
    ClientCollection clientCollection = new ClientCollection();

    private HashMap<String,Client> clientHashMap2 = clientCollection.getClientBD();
    public HashMap<String, Client> clientHashMap = new HashMap<>(){
        {
            putAll(clientHashMap2);
        }
    };


    private ArrayList<Insurance> insurensList = new ArrayList<>();
    private ArrayList<Credit> CreditList = new ArrayList<>();
    private ArrayList<AccountMoney> AccountList = new ArrayList<>();

    public ArrayList<Credit> getCreditList() {
        return CreditList;
    }

    public ArrayList<AccountMoney> getAccountList() {
        return AccountList;
    }

    public HashMap<String, Client> getClientHashMap() {
        return clientHashMap;
    }
    public ArrayList<Insurance> getInsurensList() {
        return insurensList;
    }

}

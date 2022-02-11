package com.company.bankOffice.BankService;

import com.company.Client;
import com.company.bankOffice.accountManagementDepartment.AccountMoney;
import com.company.bankOffice.creditDepartment.Credit;
import com.company.bankOffice.insuranceDepartment.Insurance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class BankCollections {
    public HashMap<String, Client> clientHashMap = new HashMap<>();
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

package com.company.bank.bankOffice.BankService;

import com.company.Client;
import com.company.bank.bankOffice.accountManagementDepartment.AccountMoney;
import com.company.bank.bankOffice.creditDepartment.bankCreditFactory.Credit;
import com.company.bank.bankOffice.insuranceDepartment.Insurance;

import java.io.Serializable;
import java.util.*;


public class BankCollections  implements Serializable {
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

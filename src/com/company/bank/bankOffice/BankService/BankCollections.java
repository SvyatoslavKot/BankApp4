package com.company.bank.bankOffice.BankService;

import com.company.Client;
import com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory.AccountMoney;
import com.company.bank.bankOffice.bankFactory.creditDepartment.bankCreditFactory.Credit;
import com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory.Insurance;
import com.company.service.Parser.CurElement;

import java.io.Serializable;
import java.util.*;


public class BankCollections  implements Serializable {
    public HashMap<String, Client> clientHashMap = new HashMap<>();
    private ArrayList<Insurance> insurensList = new ArrayList<>();
    private ArrayList<Credit> CreditList = new ArrayList<>();
    private ArrayList<AccountMoney> AccountList = new ArrayList<>();
    private HashMap<String, CurElement> currencyCBR = new HashMap<>();


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

    public HashMap<String, CurElement> getCurrencyCBR() {
        return currencyCBR;
    }
}

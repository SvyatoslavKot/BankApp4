package com.company.bank.bankOffice;



import com.company.bank.bankOffice.BankService.BankCollections;
import com.company.bank.bankOffice.bankFactory.accountDertment.AccountManagerDepartment;
import com.company.bank.bankOffice.bankFactory.creditDepartment.CreditDepartment;
import com.company.bank.bankOffice.bankFactory.insuranceDepartment.InsuranceDepartment;

import java.util.HashMap;
import java.util.Map;

public class BankOffice {
    private String nameBank;
    Atm atm;
    Kassa kassa;
    SelfTerminal terminal1;
    SelfTerminal terminal2;
    CreditDepartment creditDepartment;
    InsuranceDepartment insuranceDepartment;
    AccountManagerDepartment accountManagerDepartment;
    BankCollections bankCollections = new BankCollections();

    public BankOffice(String nameBank) {
        this.nameBank = nameBank;
        this.terminal1 = new SelfTerminal();
        this.terminal2 = new SelfTerminal();
        this.atm = new Atm();
        this.kassa = new Kassa();
        this.creditDepartment  = new CreditDepartment(this);
        this.insuranceDepartment = new InsuranceDepartment(this);
        this.accountManagerDepartment = new AccountManagerDepartment(this);
        }

    public Atm getAtm() {
        return atm;
    }

    public Kassa getKassa() {
        return kassa;
    }

    public SelfTerminal getTerminal1() {
        return terminal1;
    }

    public SelfTerminal getTerminal2() {
        return terminal2;
    }

    public CreditDepartment getCreditDepartment() {
        return creditDepartment;
    }

    public InsuranceDepartment getInsuranceDepartment() {
        return insuranceDepartment;
    }

    public AccountManagerDepartment getAccountManagerDepartment() {
        return accountManagerDepartment;
    }

    public BankCollections getBankCollections() {
        return bankCollections;
    }

    public void setBankCollections(BankCollections bankCollections) {
        this.bankCollections = bankCollections;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }
    public String getNameBank() {
        return nameBank;
    }



    public void viewClientList (){
        System.out.println("-----???????????? ????????????????-----");
        for (Map.Entry viewList: getCreditClientList().entrySet()){

            System.out.println(
                    "\n?????????? ????????????????: " + viewList.getKey() +
                            "\n?????? ??????????????: " + viewList.getValue());
        }

    }
    public void viewCreditClientList (){
        System.out.println("-----???????????? ?????????????????????? ????????????????-----");
        for (Map.Entry viewList: getCreditClientList().entrySet()){

            System.out.println(
                    "\n?????????? ???????????????????? ??????????: " + viewList.getKey() +
                            "\n?????? ??????????????: " + viewList.getValue());
        }
    }

    HashMap<String,String> creditClientList = new HashMap<>();
    HashMap<String,String> clientBankList = new HashMap<>();
    public HashMap<String, String> getCreditClientList() {
        return creditClientList;
    }
    public HashMap<String, String> getClientBankList() {
        return clientBankList;
    }


}
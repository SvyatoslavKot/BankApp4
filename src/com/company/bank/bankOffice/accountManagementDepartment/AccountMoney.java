package com.company.bank.bankOffice.accountManagementDepartment;


import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.service.GenerateAccountNumber;
import javafx.scene.input.DataFormat;

import java.text.SimpleDateFormat;

public class AccountMoney extends AccountMoneyModel {
    private String nameAccount;
    private String accountNumber;
    private int moneyInAccount;
   // private DataFormat openingDate;
    private int creditTerm;
    private int payment;
    private double cashBack;
    private String idHolder;

    private GenerateAccountNumber generateAccountNumber = new GenerateAccountNumber();

    public AccountMoney() {
    }

    public AccountMoney(String nameAccount, BankOffice bankOffice, Client client, int moneyInAccount, int creditTerm, int payment, double cashBack) {
        this.nameAccount = nameAccount;
        this.accountNumber = generateAccountNumber.accountNumber();
        this.moneyInAccount = moneyInAccount;
       // this.openingDate = new DataFormat();
        this.creditTerm = creditTerm;
        this.payment = payment;
        this.cashBack = cashBack;
        this.idHolder = client.getId();

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.println("Для "+ client.getName() + " создан " + nameAccount  +
                "\n________________ИНФОРМАЦИЯ__________________" +
                "\nномер счёта: " + accountNumber +
                //"\nдата открытия: " + dateFormat.format(openingDate) +
                "\nсроком: "+ creditTerm +" мес."+
                "\nбаланс счёта: "+ moneyInAccount+
                "\nежемесчная плата за обслуживание: "+ payment +
                "\ncashBack по карте: " + cashBack +
                "\n____________________________________________");
    }

    @Override
    void openDebitAccount(String nameCredit,int sum,int term, Client client, BankOffice bankOffice, int payment, double cashBack) {
        this.nameAccount = nameCredit;
        this.accountNumber = generateAccountNumber.accountNumber();
        this.moneyInAccount = sum;
       // this.openingDate = new DataFormat();
        this.creditTerm = term;
        this.payment = payment;
        this.cashBack = cashBack;
        this.idHolder = client.getId();

        bankOffice.getBankCollections().getAccountList().add(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.println("Для "+ client.getName() + " создан " + nameAccount  +
                "\n________________ИНФОРМАЦИЯ__________________" +
                "\nномер счёта: " + accountNumber +
               // "\nдата открытия: " + dateFormat.format(openingDate) +
                "\nсроком: "+ creditTerm +" мес."+
                "\nбаланс счёта: "+ moneyInAccount+
                "\nежемесчная плата за обслуживание: "+ payment +
                "\ncashBack по карте: " + cashBack +
                "\n____________________________________________");
    }

    public int getMoneyInAccount() {
        return moneyInAccount;
    }
    public void setMoneyInAccount(int moneyInAccount) {
        this.moneyInAccount = moneyInAccount;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getNameAccount() {
        return nameAccount;
    }

   // public DataFormat getOpeningDate() {
   //     return openingDate;
   // }

    public int getCreditTerm() {
        return creditTerm;
    }

    public int getPayment() {
        return payment;
    }

    public double getCashBack() {
        return cashBack;
    }

    public String getIdHolder() {
        return idHolder;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

   // public void setOpeningDate(DataFormat openingDate) {
   //     this.openingDate = openingDate;
   // }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }

    public void setIdHolder(String idHolder) {
        this.idHolder = idHolder;
    }
}
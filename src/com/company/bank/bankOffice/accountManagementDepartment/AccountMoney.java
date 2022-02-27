package com.company.bank.bankOffice.accountManagementDepartment;


import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.service.GenerateAccountNumber;
import javafx.scene.input.DataFormat;

import java.text.SimpleDateFormat;

public class AccountMoney  {
    private String nameAccount;
    private String accountNumber;
    private int moneyInAccount;
   // private DataFormat openingDate;
    private int creditTerm;
    private int payment;
    private double cashBack;
    private String idHolder;
    private String pin;

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
        this.pin = "0000";

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

    public void plusMoney( int money){
        setMoneyInAccount(getMoneyInAccount() + money);
    }
    public void minusMoney(int money){
        int a = 0;
        if (getMoneyInAccount() >= money){
            a = getMoneyInAccount() - money;
            setMoneyInAccount(a);
        }
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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
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
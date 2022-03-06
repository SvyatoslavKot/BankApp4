package com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory;


import com.company.bank.bankOffice.bankFactory.ProductBuilder;
import com.company.exception.MoneyAccountException;
import com.company.service.GenerateAccountNumber;

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

    public AccountMoney() {
   }
    public AccountMoney(ProductBuilder.Builder builder) {
        this.nameAccount = builder.nameProduct;
        this.accountNumber = builder.productNumber;
        this.moneyInAccount = builder.moneyInAccount;
        // private DataFormat openingDate;
        this.creditTerm = builder.term;
        this.payment = builder.payment;
        this.cashBack = builder.cashBack;
        this.idHolder = builder.clientId;
        this.pin = builder.pin;
    }
    public void plusMoney( int money){
        setMoneyInAccount(getMoneyInAccount() + money);
    }
    public void minusMoney(int money) throws MoneyAccountException {
        int a = 0;
        if (getMoneyInAccount() >= money){
            a = getMoneyInAccount() - money;
            setMoneyInAccount(a);
        }else {
            throw new MoneyAccountException("На счету недостаточно денег");
        }
    }
    public void setMoneyInAccount(int moneyInAccount) {
        this.moneyInAccount = moneyInAccount;
    }
    public int getMoneyInAccount() {
        return moneyInAccount;
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
}
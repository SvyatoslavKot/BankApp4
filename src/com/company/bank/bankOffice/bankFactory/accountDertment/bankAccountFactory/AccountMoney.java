package com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory;


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

    private AccountMoney(Builder builder) {
        this.nameAccount = builder.nameAccount;
        this.accountNumber = builder.accountNumber;
        this.moneyInAccount = builder.moneyInAccount;
        // private DataFormat openingDate;
        this.creditTerm = builder.creditTerm;
        this.payment = builder.payment;
        this.cashBack = builder.cashBack;
        this.idHolder = builder.idHolder;
        this.pin = builder.pin;
    }

    public static class Builder{
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
        public Builder() {
            this.accountNumber = generateAccountNumber.accountNumber();
            this.moneyInAccount = 0;
            this.pin = "0000";
        }

        public Builder setNameAccount(String nameAccount) {
            this.nameAccount = nameAccount;
            return this;
        }

        public Builder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setMoneyInAccount(int moneyInAccount) {
            this.moneyInAccount = moneyInAccount;
            return this;
        }

        public Builder setCreditTerm(int creditTerm) {
            this.creditTerm = creditTerm;
            return this;
        }

        public Builder setPayment(int payment) {
            this.payment = payment;
            return this;
        }

        public Builder setCashBack(double cashBack) {
            this.cashBack = cashBack;
            return this;
        }

        public Builder setIdHolder(String idHolder) {
            this.idHolder = idHolder;
            return this;
        }

        public Builder setPin(String pin) {
            this.pin = pin;
            return this;
        }
        public AccountMoney build(){
            return new AccountMoney(this);
        }
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
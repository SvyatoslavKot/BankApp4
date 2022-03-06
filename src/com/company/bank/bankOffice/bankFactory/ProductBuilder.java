package com.company.bank.bankOffice.bankFactory;

import com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory.AccountMoney;
import com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory.Insurance;
import com.company.service.GenerateAccountNumber;

import java.util.Date;

public class ProductBuilder {
    public static class Builder{
        public String nameProduct;
        public int term;
        public String productNumber;
        public String clientId;

        public int moneyInAccount;
        public int payment;
        public double cashBack;
        public String pin;

        public double price;
        public Date openDate;
        public String info;

        public int insuranceValue;
         GenerateAccountNumber generateAccountNumber = new GenerateAccountNumber();

        public Builder() {
            this.productNumber = generateAccountNumber.accountNumber();
        }
        public Builder setNameProduct(String nameProduct) {
            this.nameProduct = nameProduct;
            return this;
        }
        public Builder setNumber(String productNumber) {
            this.productNumber = productNumber;
            return  this;
        }
        public Builder setTerm(int term) {
            this.term = term;
            return this;
        }
        public Builder setClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }
        public Builder setInsirancePrice(double price) {
            this.price = price;
            return this;
        }
        public Builder setInsuranceValue(int insuranceValue) {
            this.insuranceValue = insuranceValue;
            return this;
        }

        public Builder setMoneyInAccount(int moneyInAccount) {
            this.moneyInAccount = moneyInAccount;
            return this;
        }
        public Builder setPayment(int payment){
            this.payment = payment;
            return this;
        }
        public Builder setCashBack(double cashBack){
            this.cashBack = cashBack;
            return this;
        }
        public  Builder setPin (String pin){
            this.pin = pin;
            return this;
        }

        public Insurance buildInsurance (){
            return new Insurance( this);
        }
        public AccountMoney buildAccount(){
            return new AccountMoney(this);
        }
    }
}

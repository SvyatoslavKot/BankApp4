package com.company.bank.bankOffice.bankFactory;

import com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory.AccountMoney;
import com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory.Insurance;
import com.company.service.GenerateAccountNumber;

import java.util.Date;

public class ProductBuilder {
    public static class Builder{
        public String nameInsurance;
        public int insuranceValue;
        public double price;
        public int term;
        public Date openDate;
        public String insuranceNumber;
        public String clientId;
        public String info;

         GenerateAccountNumber generateAccountNumber = new GenerateAccountNumber();

        public Builder() {
            this.insuranceNumber = generateAccountNumber.accountNumber();
        }
        public Builder setNameProduct(String nameInsurance) {
            this.nameInsurance = nameInsurance;
            return this;
        }
        public Builder setNumber(String insuranceNumber) {
            this.insuranceNumber = insuranceNumber;
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
        public Insurance build (){
            return new Insurance( this);
        }
    }
}

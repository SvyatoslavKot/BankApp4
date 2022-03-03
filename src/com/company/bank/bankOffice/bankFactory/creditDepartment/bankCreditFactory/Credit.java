package com.company.bank.bankOffice.bankFactory.creditDepartment.bankCreditFactory;

import com.company.service.CreditCalculationPayment;
import com.company.service.GenerateAccountNumber;

import java.util.Date;

public class Credit {
    private String creditName ;
    private String accountNumber ;
    private int amount ;
    private double ptc ;
    private Date openingDate;
    private int creditTerm;
    private double paymentMonth;
    private String idHolder;

    static GenerateAccountNumber generateAccountNumber = new GenerateAccountNumber();

    protected Credit(Builder builder){
        this.accountNumber = builder.accountNumber;
        this.amount = builder.amount;
        this.creditName = builder.creditName;
        this.creditTerm = builder.creditTerm;
        this.openingDate= builder.openingDate;
        this.paymentMonth = builder.paymentMouth;
        this.ptc = builder.ptc;
        this.idHolder = builder.idHolder;
    }


    public static class Builder {
        private String creditName;
        private String accountNumber;
        private int amount;
        private double ptc;
        private Date openingDate;
        private int creditTerm;
        private double paymentMouth;
        private String idHolder;

        CreditCalculationPayment payment = new CreditCalculationPayment();

        public Builder() {
            this.accountNumber = generateAccountNumber.accountNumber();
            this.openingDate = new Date();
        }
        public Builder setCreditName(String creditName) {
            this.creditName = creditName;
            return this;
        }
        public Builder setPaymentMouth(double paymentMouth) {
            this.paymentMouth = paymentMouth;
            return this;
        }
        public Builder setAmount(int amount) {
                this.amount = amount;
                return this;
            }
            public Builder setPtc(double ptc) {
                this.ptc = ptc;
                return this;
            }
            public Builder setCreditTerm(int creditTerm) {
                this.creditTerm = creditTerm;
                return this;
            }
        public Builder setIdHolder(String idHolder) {
            this.idHolder = idHolder;
            return this;
        }        public Builder calckPaymentMounth(int amount, double ptc, int creditTerm){
            this.paymentMouth = payment.calc(amount,ptc,creditTerm);
            return this;
        }
        public Credit build(){
            return new Credit(this);
        }
    }

    public String getCreditName() {
        return creditName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public int getAmount() {
        return amount;
    }
    public double getPtc() {
        return ptc;
    }
    public Date getOpeningDate() {
        return openingDate;
    }
    public int getCreditTerm() {
        return creditTerm;
    }
    public double getPaymentMonth() {
        return paymentMonth;
    }
    public String getIdHolder() {
        return idHolder;
    }

}

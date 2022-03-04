package com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory;

import com.company.bank.bankOffice.bankFactory.ProductBuilder;
import com.company.service.GenerateAccountNumber;

import java.util.Date;

public class Insurance  {
    private String nameInsurance;
    private int insuranceValue;
    private double price;
    private int term;
    private Date openDate;
    private String insuranceNumber;
    private String clientId;
    private String info;
    private GenerateAccountNumber generateAccountNumber = new GenerateAccountNumber();

     public Insurance() {
    }
     public Insurance(ProductBuilder.Builder builder) {
        this.nameInsurance = builder.nameProduct;
        this.insuranceValue = builder.insuranceValue;
        this.price = builder.price;
        this.term = builder.term;
        this.openDate = new Date();
        this.insuranceNumber = builder.productNumber;
        this.clientId = builder.clientId;
    }

    @Override
    public String toString() {
        return "Insurance{"+ price +'}';
    }
    public String getNameInsurance() {
        return nameInsurance;
    }
    public int getInsuranceValue() {
        return insuranceValue;
    }
    public double getPrice() {
        return price;
    }
    public int getTerm() {
        return term;
    }
    public Date getOpenDate() {
        return openDate;
    }
    public String getInsuranceNumber() {
        return insuranceNumber;
    }
    public String getClientId() {
        return clientId;
    }
    public String getInfo() {
        return info;
    }
}

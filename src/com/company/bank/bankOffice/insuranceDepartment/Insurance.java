package com.company.bank.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.service.GenerateAccountNumber;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Insurance extends InsuranceModel implements Comparable {
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

    public Insurance(BankOffice bankOffice, Client client, String nameInsurance, int insuranceValue, double price, int term) {
        this.nameInsurance = nameInsurance;
        this.insuranceValue = insuranceValue;
        this.price = price;
        this.term = term;
        this.openDate = new Date();
        this.insuranceNumber = generateAccountNumber.accountNumber();
        this.clientId = client.getId();
    }

    @Override
    public String openInsurance(Client client, BankOffice bankOffice, int insuranceValue, double price, int term) {
        this.nameInsurance = "Страхование";
        this.insuranceNumber = generateAccountNumber.accountNumber();
        this.price = price;
        this.term = term;
        this.openDate = new Date();
        this.insuranceValue = insuranceValue;
        this.clientId = client.getId();

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        bankOffice.getBankCollections().getInsurensList().add(this);
        this.info = " вы оформили страховку " + this.nameInsurance +
                "\n________________ИНФОРМАЦИЯ__________________" +
                "\nномер счёта: " + insuranceNumber +
                "\nсрок страхования: " + this.term + " мес." +
                "\nдата открытия: " + dateFormat.format(openDate) +
                "\nстоимость стрхования: " + this.price +
                "\nстраховая сумма: " + this.insuranceValue +
                "\n____________________________________________";

        return "Создана страховка с номером " + this.nameInsurance;
    }

    @Override
    public int compareTo(Insurance o1, Insurance o2) {
        return 0;
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

    @Override
    public String toString() {
        return "Insurance{"+ price +'}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

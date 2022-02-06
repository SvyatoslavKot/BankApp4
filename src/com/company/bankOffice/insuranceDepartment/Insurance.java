package com.company.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;
import com.company.service.GenerateAccountNumber;

import javax.management.ObjectName;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Insurance extends InsuranceModel implements Comparable {
    private String nameInsurance;
    private int insuranceValue;
    private double price;
    private int term;
    private Date openDate;
    private String insuranceNumber;
    private String clientId;
    private String info;

    private GenerateAccountNumber generateAccountNumber = new GenerateAccountNumber();

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

}

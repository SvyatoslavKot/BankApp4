package com.company.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;
import com.company.service.GenerateAccountNumber;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsuranceModel extends Insurance {
    private String nameInsurance;
    private int insuranceValue;
    private int price;
    private int term;
    private Date openDate;
    private String insuranceNumber;
    private String clientId;

    private GenerateAccountNumber generateAccountNumber = new GenerateAccountNumber();
    @Override
    void openInsurance(Client client, BankOffice bankOffice,String nameInsurance, int insuranceValue, int price, int term){
        this.nameInsurance = nameInsurance;
        this.insuranceNumber = generateAccountNumber.accountNumber();
        this.price = price;
        this.term = term;
        this.openDate = new Date();
        this.insuranceValue = insuranceValue;
        this.clientId = client.getId();

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.println(client.getName() + " вы оформили страховку " + this.nameInsurance +
                "\n________________ИНФОРМАЦИЯ__________________" +
                "\nномер счёта: " + insuranceNumber +
                "\nсрок страхования: " + this.term + " мес." +
                "\nдата открытия: " + dateFormat.format(openDate) +
                "\nстоимость стрхования: " + this.price +
                "\nстраховая сумма: " + this.insuranceValue +
                "\n____________________________________________");

    }



}

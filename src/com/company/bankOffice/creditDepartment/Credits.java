package com.company.bankOffice.creditDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;

import java.util.Date;

public abstract class Credits {
    private String creditName;
    private String accountNumber;
    private int amount;
    private double ptc;
    private Date openingDate;
    private int creditTerm;
    private double paymentMonth;

    public abstract void openCredit(String creditName, Client a, int sum, BankOffice bankOffice, double ptc, int creditTerm);

    public abstract void openCredit(String creditName, int sum,  double ptc, int creditTerm );
}
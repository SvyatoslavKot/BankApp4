package com.company.bankOffice.creditDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;

public abstract class Credits {
    private String creditName;
    private String accountNumber;
    private int amount;
    private double ptc;
    private String openingDate;
    private int creditTerm;
    private double paymentMonth;

    abstract void openCredit(String creditName, Client a, int sum, BankOffice bankOffice, double ptc, int creditTerm);
}
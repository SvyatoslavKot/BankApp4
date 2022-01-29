package com.company.bankOffice.creditDepartment;

import com.company.Client;
import com.company.service.CreditCalculationPayment;
import com.company.service.CreditType;
import com.company.service.GenerateAccountNumber;
import com.company.bankOffice.BankOffice;

import java.util.HashMap;
import java.util.Scanner;

public class CreditAccount {
    private String creditName;
    private String accountNumber;
    private int amount;
    private double ptc;
    private String openingDate;
    private int creditTerm;
    private String nameHolder;
    private String lastNameHolder;
    private String passportHolder;
    private int ageHolder;
    private int incomeHolder;
    private double paymentMonth;

    CreditModel credit = new CreditModel();
    Scanner scanner = new Scanner(System.in);
    CreditType creditType = new CreditType();
    public void openCredit(Client client , BankOffice bankOffice){
        System.out.println(client.getName() + " введи тип кредита \n" +
                "1 - Потребительский/ 2 - Автокредит/ 3- Ипотека");
        String type = scanner.nextLine();
        switch (type) {
            case "1":
                creditType.getConsumerCredit(client, bankOffice, credit, scanner);
                break;
            case "2" :
                creditType.getAutoCredit(client, bankOffice, credit, scanner);
                break;
            case "3" :
                creditType.getHomeCredit(client, bankOffice, credit, scanner);
                break;
            case "4" :
                creditType.getCreditCard(client, bankOffice, credit, scanner);
                break;
            default: System.out.print("Неверная операция");
        }
    }
    public int putMoneyOnCreditAmount( int money){

        int a;
        a = getAmount() - money;
        setAmount(a);
        return getAmount();
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}

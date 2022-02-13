package com.company.bank.bankOffice.creditDepartment;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

import java.util.Scanner;

public class CreditController {
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

    //Credit credit = new Credit();
    Scanner scanner = new Scanner(System.in);
    public Credit openCredit(Client client , BankOffice bankOffice,int sum, String type, int creditTerm){
        switch (type) {
            case "Потребительский":
                if (sum < 50000){
                    return null;
                    //credit.openCreditCard("Кредитная карта", client, sum, bankOffice, 18.9);
                }else if (sum > 50000 && sum <= 100000 ){
                    return new Credit(type,client,sum,bankOffice,17.9,creditTerm);
                }else if (sum > 100000 && sum <= 200000 ){
                    return  new Credit(type,client,sum,bankOffice,15.9,creditTerm);
                }else if (sum > 200000 && sum <= 500000 ){
                    return new Credit(type,client,sum,bankOffice,17.9,creditTerm);
                }else if (sum > 500000 && sum <= 1000000 ){
                    return new Credit(type,client,sum,bankOffice,17.9,creditTerm);
                }else if (sum > 1000000 && sum <= 2000000 ){
                    return  new Credit(type,client,sum,bankOffice,17.9,creditTerm);
                }else {
                    return null;
                }
             case "Автокредит" :
                if (sum < 100000){
                    //credit.openCreditCard("Кредитная карта", client, sum, bankOffice, 18.9);
                }else if (sum > 100000 && sum <= 300000 ){
                    return  new Credit(type,client,sum,bankOffice,17.9,creditTerm);
                }else if (sum > 300000 && sum <= 500000 ){
                    return  new Credit(type,client,sum,bankOffice,15.9,creditTerm);
                }else if (sum > 500000 && sum <= 1000000 ){
                    return  new Credit(type,client,sum,bankOffice,12.9,creditTerm);
                }else if (sum > 1000000 && sum <= 2000000 ){
                    return  new Credit(type,client,sum,bankOffice,9.9,creditTerm);
                }else if (sum > 2000000 && sum <= 3000000 ){
                    return  new Credit(type,client,sum,bankOffice,6.9,creditTerm);
                }else {
                    return null;
                }
           case  "Иппотека" :
                if (sum < 1000000){
                    return null;
                }else if (sum > 1000000 && sum <= 1300000 ){
                    return  new Credit(type,client,sum,bankOffice,12.9,creditTerm);
                }else if (sum > 1300000 && sum <= 1500000 ){
                    return  new Credit(type,client,sum,bankOffice,10.9,creditTerm);
                }else if (sum > 1500000 && sum <= 5000000 ){
                    return  new Credit(type,client,sum,bankOffice,8.9,creditTerm);
                }else if (sum > 5000000 && sum <= 10000000 ){
                    return  new Credit(type,client,sum,bankOffice,5.9,creditTerm);
                }else if (sum > 10000000 && sum <= 30000000 ){
                    return  new Credit(type,client,sum,bankOffice,3.9,creditTerm);
                }else {
                    return null;
                }
            case  "Кредитная карта" :
                if (sum < 10000){
                    return null;
                }else if (sum > 10000 && sum <= 30000 ){
                    return  new Credit(type,client,sum,bankOffice,25.9,creditTerm);
                }else if (sum > 30000 && sum <= 100000 ){
                    return  new Credit(type,client,sum,bankOffice,23.9,creditTerm);
                }else if (sum > 100000 && sum <= 2000000 ){
                    return  new Credit(type,client,sum,bankOffice,19.9,creditTerm);
                }else {
                    return null;
                }
            default: System.out.println("Неверная операция");
        }
        return null;
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

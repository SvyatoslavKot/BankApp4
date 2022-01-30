package com.company.bankOffice.creditDepartment;

import com.company.Client;
import com.company.service.CreditCalculationPayment;
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
    public void openCredit(Client client , BankOffice bankOffice){
        System.out.println(client.getName() + " ввведи тип кредита \n" +
                "1 - Потребительсикий/ 2 - Автокредит/ 3- Ипотека");
        String type = scanner.nextLine();
        switch (type) {
            case "1":
                System.out.println(client.getName() + " ввведи желаемую ссуму займа по потребительскому кредиту :");
                int sum = scanner.nextInt();
                if (sum < 50000){
                    System.out.println(client.getName()+ " мы можем предложить вам кредитную карту.");
                }else if (sum > 50000 && sum <= 100000 ){
                    credit.openCredit("Потребительский 100",client, sum,bankOffice,17.9,12);
                }else if (sum > 100000 && sum <= 200000 ){
                    credit.openCredit("Потребительский 200",client, sum,bankOffice,15.9,24);
                }else if (sum > 200000 && sum <= 500000 ){
                    credit.openCredit("Потребительский 500",client, sum,bankOffice,13.9,24);
                }else if (sum > 500000 && sum <= 1000000 ){
                    credit.openCredit("Потребительский миллион",client, sum,bankOffice,11.9,36);
                }else if (sum > 1000000 && sum <= 2000000 ){
                    credit.openCredit("Потребительский 2 ляма",client, sum,bankOffice,9.9,60);
                }else {
                    System.out.println("Для вас нет подходящих предложение потребительского кредита.");
                }break;
            case "2" :
                System.out.println(client.getName() + " ввведи желаемую ссуму займа по автокредиту :");
                int sum1 = scanner.nextInt();
                if (sum1 < 100000){
                    System.out.println(client.getName()+ " мы можем предложить вам кредитную карту.");
                }else if (sum1 > 100000 && sum1 <= 300000 ){
                    credit.openCredit("Авто 300",client, sum1,bankOffice,17.9,12);
                }else if (sum1 > 300000 && sum1 <= 500000 ){
                    credit.openCredit("Авто 500",client, sum1,bankOffice,15.9,24);
                }else if (sum1 > 500000 && sum1 <= 1000000 ){
                    credit.openCredit("Авто лям",client, sum1,bankOffice,12.9,36);
                }else if (sum1 > 1000000 && sum1 <= 2000000 ){
                    credit.openCredit("Авто 2 ляма",client, sum1,bankOffice,9.9,60);
                }else if (sum1 > 2000000 && sum1 <= 3000000 ){
                    credit.openCredit("Авто 3 ляма",client, sum1,bankOffice,6.9,60);
                }else {
                    System.out.println("Для вас нет подходящих предложение потребительского кредита.");
                }break;
            case "3" :
                System.out.println(client.getName() + " ввведи желаемую ссуму займа по ипотеке :");
                int sum2 = scanner.nextInt();
                if (sum2 < 1000000){
                    System.out.println(client.getName()+ " мы можем предложить вам потребительский кредит.");
                }else if (sum2 > 1000000 && sum2 <= 1300000 ){
                    credit.openCredit("Ипотека 1",client, sum2,bankOffice,11.9,120);
                }else if (sum2 > 1300000 && sum2 <= 1500000 ){
                    credit.openCredit("Ипотека 2",client, sum2,bankOffice,10.9,180);
                }else if (sum2 > 1500000 && sum2 <= 5000000 ){
                    credit.openCredit("Ипотека 3",client, sum2,bankOffice,8.9,240);
                }else if (sum2 > 5000000 && sum2 <= 10000000 ){
                    credit.openCredit("Ипотека 4",client, sum2,bankOffice,5.9,360);
                }else if (sum2 > 10000000 && sum2 <= 30000000 ){
                    credit.openCredit("Ипотека 5",client, sum2,bankOffice,3.9,360);
                }else {
                    System.out.println("Для вас нет подходящих предложений");
                }break;

            default: System.out.println("Неверная операция");
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

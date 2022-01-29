package com.company.service;

import com.company.Client;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.creditDepartment.CreditModel;

import java.util.Scanner;

public class CreditType {
    public void getConsumerCredit(Client client, BankOffice bankOffice, CreditModel credit, Scanner scanner){
        System.out.println(client.getName() + " введи желаемую сумму займа по потребительскому кредиту :");
        int sum = scanner.nextInt();
        if (sum >= 10000 && sum <= 50000){
            System.out.println(client.getName()+ " мы можем предложить вам кредитную карту. \n" +
                    "Выберите вариант ответа: 1 - Да/ 2 - Нет");
            if (scanner.nextInt() == 1)
                getCreditCard(client, bankOffice, credit, scanner);
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
        }
    }

    public void getAutoCredit(Client client, BankOffice bankOffice, CreditModel credit, Scanner scanner){
        System.out.println(client.getName() + " введи желаемую сумму займа по автокредиту :");
        int sum = scanner.nextInt();
        if (sum >= 10000 && sum <= 100000){
            System.out.println(client.getName()+ " мы можем предложить вам кредитную карту. \n" +
                    "Выберите вариант ответа: 1 - Да/ 2 - Нет");
            if (scanner.nextInt() == 1)
                getCreditCard(client, bankOffice, credit, scanner);
        }else if (sum > 100000 && sum <= 300000 ){
            credit.openCredit("Авто 300",client, sum,bankOffice,17.9,12);
        }else if (sum > 300000 && sum <= 500000 ){
            credit.openCredit("Авто 500",client, sum,bankOffice,15.9,24);
        }else if (sum > 500000 && sum <= 1000000 ){
            credit.openCredit("Авто лям",client, sum,bankOffice,12.9,36);
        }else if (sum > 1000000 && sum <= 2000000 ){
            credit.openCredit("Авто 2 ляма",client, sum,bankOffice,9.9,60);
        }else if (sum > 2000000 && sum <= 3000000 ){
            credit.openCredit("Авто 3 ляма",client, sum,bankOffice,6.9,60);
        }else {
            System.out.println("Для вас нет подходящих предложений автокредита.");
        }
    }

    public void getHomeCredit(Client client, BankOffice bankOffice, CreditModel credit, Scanner scanner){
        System.out.println(client.getName() + " введи желаемую сумму займа по ипотеке :");
        int sum = scanner.nextInt();
        if (sum >= 10000 && sum <= 1000000){
            System.out.println(client.getName()+ " мы можем предложить вам потребительский кредит.\n" +
                    "Выберите вариант ответа: 1 - Да/ 2 - Нет");
            if (scanner.nextInt() == 1)
                getConsumerCredit(client, bankOffice, credit, scanner);
        }else if (sum > 1000000 && sum <= 1300000 ){
            credit.openCredit("Ипотека 1",client, sum,bankOffice,11.9,120);
        }else if (sum > 1300000 && sum <= 1500000 ){
            credit.openCredit("Ипотека 2",client, sum,bankOffice,10.9,180);
        }else if (sum > 1500000 && sum <= 5000000 ){
            credit.openCredit("Ипотека 3",client, sum,bankOffice,8.9,240);
        }else if (sum > 5000000 && sum <= 10000000 ){
            credit.openCredit("Ипотека 4",client, sum,bankOffice,5.9,360);
        }else if (sum > 10000000 && sum <= 30000000 ){
            credit.openCredit("Ипотека 5",client, sum,bankOffice,3.9,360);
        }else {
            System.out.println("Для вас нет подходящих предложений");
        }
    }

    public void getCreditCard(Client client, BankOffice bankOffice, CreditModel credit, Scanner scanner){
        System.out.println(client.getName() + " введи желаемую сумму займа по кредитной карте :");
        int sum = scanner.nextInt();
        if (sum >= 10000 && sum <= 100000){
            credit.openCreditCard("Кредитная карта", client, sum, bankOffice, 18.9);
        }else {
            System.out.println("Для вас нет подходящих предложений.");
        }
    }
}

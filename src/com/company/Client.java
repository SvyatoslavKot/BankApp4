package com.company;



import com.company.bankOffice.BankOffice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client implements Comparable{
    private String name;
    private String lastName;
    private String id;
    private int age;
    private int income;
    private int cash;
    private String passport;
    private boolean bankAccount = false;

    Scanner scanner = new Scanner(System.in);
    //WaitingInLine waitingInLine = new WaitingInLine();
    HashMap<String,String> creditListClient = new HashMap<>();
    HashMap<String,String> debitAccount = new HashMap<>();

    public Client(String name,String id, int income, int cash, String passport) {
        this.name = name;
        this.id = id;
        this.income = income;
        this.cash = cash;
        this.passport = passport;
    }
    public Client() {
        System.out.println("Ведите имя клиент.");
        String nameScan = scanner.nextLine();
        // System.out.println("Ведите фамилию клиент.");
        // String lastNameScan = scanner.nextLine();
        System.out.println("Введите номер паспорта.");
        String passportScan = scanner.nextLine();
        //System.out.println("Ведите возраст клиент.");
        // int ageScan = scanner.nextInt();
        // System.out.println("Ведите доход клиента.");
        // int incomeScan = scanner.nextInt();
        // System.out.println("Сколько наличных у клиента");
        // int cashScan = scanner.nextInt();


        System.out.println("Создан клиент.");
        this.name = nameScan;
        // this.lastName = lastNameScan;
        // this.age = ageScan;
        this.passport = passportScan;
        //this.income = incomeScan;
        //this.cash = cashScan;
    }


    public void viewCreditAccount (){

        System.out.println("-----Список кредитов"+" " + getName() +"-----");
        for (Map.Entry viewList: getCreditListClient().entrySet()){

            System.out.println(
                    "\nНомер кредитного счёта: " + viewList.getKey() +
                            "\nНазвания кредита: " + viewList.getValue());
        }
    }
    public void viewDebitAccount (){
        System.out.println("-----Список дебетовых счетов"+" " + getName() +"-----");
        for (Map.Entry viewList: getCreditListClient().entrySet()){

            System.out.println(
                    "\nНомер дебетого счёта: " + viewList.getKey() +
                            "\nНазвания счёта: " + viewList.getValue());
        }
    }




    public String getPassport() {
        return passport;
    }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public int getIncome() {
        return income;
    }
    public int getCash() {
        return cash;
    }
    public void setCash(int cash) {
        this.cash = cash;
    }
    public boolean isBankAccount() {
        return bankAccount ;
    }
    public void setBankAccount(boolean bankCard) {
        this.bankAccount = bankCard;
    }

    public HashMap<String, String> getCreditListClient() {
        return creditListClient;
    }

    public HashMap<String, String> getDebitAccount() {
        return debitAccount;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
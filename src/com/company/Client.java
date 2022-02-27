package com.company;



import java.io.Serializable;
import java.util.Objects;

public class Client implements Serializable {
    private String name;
    private String lastName;
    private String id;
    private int age;
    private int income;
    private int cash;
    private String passport;
    private boolean bankAccount = false;


    public Client() {
    }

    public Client(String name,String lastName,int age, String id, int income, int cash, String passport) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
        this.income = income;
        this.cash = cash;
        this.passport = passport;
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

    public boolean isBankAccount() {
        return bankAccount ;
    }
    public void setBankAccount(boolean bankCard) {
        this.bankAccount = bankCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", income=" + income +
                ", cash=" + cash +
                ", passport='" + passport + '\'' +
                '}';
    }


}
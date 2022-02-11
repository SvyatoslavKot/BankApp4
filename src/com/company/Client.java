package com.company;



import java.util.Objects;

public class Client  {
    private String name;
    private String lastName;
    private String id;
    private int age;
    private int income;
    private int cash;
    private String passport;
    private boolean bankAccount = false;

    public Client(String name,String id, int income, int cash, String passport) {
        this.name = name;
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
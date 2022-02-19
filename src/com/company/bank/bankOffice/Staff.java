package com.company.bank.bankOffice;


public abstract class Staff {

    private String name;
    private int age;
    private String position;
    private int tabNum;
    private String dep;

    public Staff(String name, int age, String position, int tabNum, String dep) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.tabNum = tabNum;
        this.dep = dep;
    }

    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    public int getTabNum() {
        return tabNum;
    }

    public String getDep() {
        return dep;
    }
}

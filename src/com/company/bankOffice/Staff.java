package com.company.bankOffice;


public abstract class Staff {

    private String name;
    private int age;
    private String position;

    public Staff(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }


}

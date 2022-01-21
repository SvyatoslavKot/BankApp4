package com.company.bankOffice;


public abstract class Staff {

    private String name;
    private int age;
    private String position;

    public void initializationManager(String name, int age, String position){
        this.name = name;
        this.age = age;
        this.position = position;
        System.out.println("С клиентом работает "+ getPosition()+" " + getName());
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }


}

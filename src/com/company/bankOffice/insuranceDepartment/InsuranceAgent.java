package com.company.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.bankOffice.Staff;

public class InsuranceAgent extends Staff {

    public InsuranceAgent(String name, int age, String position, Insurance insurance) {
        super(name, age, position);
        this.insurance = insurance;
    }

    private Insurance insurance = new Insurance();

    public Insurance getInsurance(Client client) {
        System.out.println("Принята заявка на оформление страхования от клиента " + client.getLastName()  + " " + client.getName());
        return insurance;
    }
}
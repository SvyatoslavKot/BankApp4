package com.company.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.BankService.BankCollectionManage;
import com.company.bankOffice.BankService.BankCollections;
import com.company.bankOffice.Staff;

public class InsuranceAgent extends Staff {
    public InsuranceAgent(String name, int age, String position) {super(name, age, position);}

    BankCollectionManage manageInsurance = new BankCollectionManage();

    public void viewInsuranceByClient(Client client, BankOffice bankOffice){
        System.out.println("_____"+getPosition() + " " + getName() + " WORKING ____");
        System.out.println(client.getName() + " у вас есть следующие страховки:");
        manageInsurance.viewInsuranceByClient(client,bankOffice);
    }
}
package com.company.bank.bankOffice.bankFactory.insuranceDepartment;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.BankService.BankCollectionManage;
import com.company.bank.bankOffice.Staff;

public class InsuranceAgent extends Staff {
    public InsuranceAgent(String name, int age, String position, int tabNum, String dep) {super(name, age, position, tabNum, dep);}

    BankCollectionManage manageInsurance = new BankCollectionManage();

    public void viewInsuranceByClient(Client client, BankOffice bankOffice){
        System.out.println("_____"+getPosition() + " " + getName() + " WORKING ____");
        System.out.println(client.getName() + " у вас есть следующие страховки:");
        manageInsurance.viewInsuranceByClient(client,bankOffice);
    }
}
package com.company.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;

import java.util.Scanner;

public class InsuranceOpen {
    Scanner scanner = new Scanner(System.in);
    InsuranceModel insuranceModel = new InsuranceModel();

    public void openInsurance (Client client, BankOffice bankOffice){
        insuranceModel.openInsurance(client,bankOffice,"Страхование жизни",600000,600,12);
    }
}

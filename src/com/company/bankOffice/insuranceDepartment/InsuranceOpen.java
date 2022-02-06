package com.company.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;

import java.util.Scanner;

public class InsuranceOpen {
    Scanner scanner = new Scanner(System.in);
    Insurance insuranceModel = new Insurance() {
        @Override
        public int compareTo(Object o) {
            return 0;
        }
    };


    public void openInsurance (Client client, BankOffice bankOffice){

        System.out.println("Введите страховую сумму");
        int value  = scanner.nextInt();
        System.out.println("Введите желаемый срок страхования до 12 месяцев:");
        int term = scanner.nextInt();
        double price = 0;
        if (term == 1){
           price = (value / 1000 )* 0.2 ;
            insuranceModel.openInsurance(client,bankOffice, value,price,term);
        }else if (term >1 && term <=3 ){
            price= (value / 1000) * 0.4;
            insuranceModel.openInsurance(client,bankOffice, value,price,term);
        }else  if (term > 3 && term <= 6) {
            price = (value / 1000) * 0.6;
            insuranceModel.openInsurance(client,bankOffice, value,price,term);
        }else  if (term > 6 && term <= 9) {
            price = (value / 1000) * 0.6;
            insuranceModel.openInsurance(client,bankOffice, value,price,term);
        }else if (term > 9 && term <= 12) {
            price = value / 1000;
            insuranceModel.openInsurance(client,bankOffice, value,price,term);
        }else {
            System.out.println("Неверная операция.");
        }

    }
}

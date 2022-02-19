package com.company.bank.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

import java.util.Scanner;

public class InsuranceOpen {
       public Insurance openInsurance (Client client, BankOffice bankOffice, String type, int insuranceValue,int term){
           switch (type) {
               case "Жизнь":
                   return openInsuranceLive(client,bankOffice,insuranceValue,term);
               case "Имущество":
                   return openInsuranceProperty(client,bankOffice,insuranceValue,term);
        }return null;

    }


    public Insurance openInsuranceLive(Client client, BankOffice bankOffice,int insuranceValue,int term){
        if (term == 1){
            double price = (insuranceValue / 1000 )* 0.2 ;
            return new Insurance(bankOffice, client, "Жизни", insuranceValue, price, term);
        }else if (term >1 && term <=3 ){
            double price= (insuranceValue / 1000) * 0.4;
            return new Insurance(bankOffice, client, "Жизни2", insuranceValue, price, term);
        }else  if (term > 3 && term <= 6) {
            double price = (insuranceValue / 1000) * 0.6;
            return new Insurance(bankOffice, client, "Жизни3", insuranceValue, price, term);
        }else  if (term > 6 && term <= 9) {
            double price = (insuranceValue / 1000) * 0.6;
            return new Insurance(bankOffice, client, "Жизни4", insuranceValue, price, term);
        }else if (term > 9 && term <= 12) {
            double price = insuranceValue / 1000;
            return new Insurance(bankOffice, client, "Жизни5", insuranceValue, price, term);
        }else {
            return  null;
        }
    }
    public Insurance openInsuranceProperty(Client client, BankOffice bankOffice,int insuranceValue,int term){
        if (term == 1){
            double price = (insuranceValue / 1000 )* 0.2 ;
            return new Insurance(bankOffice, client, "Иммущество", insuranceValue, price, term);
        }else if (term >1 && term <=3 ){
            double price= (insuranceValue / 1000) * 0.4;
            return new Insurance(bankOffice, client, "Иммущество2", insuranceValue, price, term);
        }else  if (term > 3 && term <= 6) {
            double price = (insuranceValue / 1000) * 0.6;
            return new Insurance(bankOffice, client, "Иммущество3", insuranceValue, price, term);
        }else  if (term > 6 && term <= 9) {
            double price = (insuranceValue / 1000) * 0.6;
            return new Insurance(bankOffice, client, "Иммущество4", insuranceValue, price, term);
        }else if (term > 9 && term <= 12) {
            double price = insuranceValue / 1000;
            return new Insurance(bankOffice, client, "Иммущество5", insuranceValue, price, term);
        }else {
            return  null;
        }
    }
}

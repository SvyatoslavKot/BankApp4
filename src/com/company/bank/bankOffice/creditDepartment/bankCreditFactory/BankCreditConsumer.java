package com.company.bank.bankOffice.creditDepartment.bankCreditFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.service.CreditCalculationPayment;

import java.util.Date;

public class BankCreditConsumer implements CreditCreater {
    CreditCalculationPayment calculationPayment = new CreditCalculationPayment();

    public Credit create(BankOffice bankOffice, Client client, int sum, String type, int creditTerm ) {
        if (sum < 50000){
            return new BankCreditCard().create(bankOffice,client,sum,type,creditTerm);
        }else if (sum > 50000 && sum <= 100000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Потребительский 1").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(19.99).setIdHolder(client.getId()).calckPaymentMounth(sum,19.99,creditTerm).build();
            return creditCons;
        }else if (sum > 100000 && sum <= 200000 ){
            Credit creditCons = new Credit.Builder().setCreditName( "Потребительский 2").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(15.9).setIdHolder(client.getId()).calckPaymentMounth(sum,15.9,creditTerm).build();
            return creditCons;
        }else if (sum > 200000 && sum <= 500000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Потребительский 3").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(14.8).setIdHolder(client.getId()).calckPaymentMounth(sum,14.8,creditTerm).build();
            return creditCons;
        }else if (sum > 500000 && sum <= 1000000 ){
            Credit creditCons = new Credit.Builder().setCreditName( "Потребительский 4").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(12.9).setIdHolder(client.getId()).calckPaymentMounth(sum,12.9,creditTerm).build();
            return creditCons;
        }else if (sum > 1000000 && sum <= 2000000 ){
            Credit creditCons = new Credit.Builder().setCreditName( "Потребительский 5").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(10.89).setIdHolder(client.getId()).calckPaymentMounth(sum,10.89,creditTerm).build();
            return creditCons;
        }else {
            return null;
        }
    }
}

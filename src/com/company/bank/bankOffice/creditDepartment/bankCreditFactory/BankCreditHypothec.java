package com.company.bank.bankOffice.creditDepartment.bankCreditFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

import java.util.Date;

public class BankCreditHypothec implements CreditCreater {
    @Override
    public Credit create(BankOffice bankOffice, Client client, int sum, String type, int creditTerm) {
        if (sum <=700000){
            return new BankCreditConsumer().create(bankOffice,client,sum,type,creditTerm);
        }else if (sum > 700000 && sum <= 1000000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Ипотека 1").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(12.99).setIdHolder(client.getId()).calckPaymentMounth(sum,12.99,creditTerm).build();
            return creditCons;
        }else if (sum > 1000000 && sum <= 1500000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Ипотека 2").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(10.9).setIdHolder(client.getId()).calckPaymentMounth(sum,10.9,creditTerm).build();
            return creditCons;
        }else if (sum > 1500000 && sum <= 2200000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Ипотека 3").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(9.8).setIdHolder(client.getId()).calckPaymentMounth(sum,9.8,creditTerm).build();
            return creditCons;
        }else if (sum > 2200000 && sum <= 4500000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Ипотека 4").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(6.9).setIdHolder(client.getId()).calckPaymentMounth(sum,6.9,creditTerm).build();
            return creditCons;
        }else if (sum > 4500000 && sum <= 7000000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Ипотека 5").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(4.89).setIdHolder(client.getId()).calckPaymentMounth(sum,4.89,creditTerm).build();
            return creditCons;
        }else {
            return null;
        }
    }
}

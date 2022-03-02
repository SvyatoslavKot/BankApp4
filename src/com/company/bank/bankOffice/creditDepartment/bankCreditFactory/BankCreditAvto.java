package com.company.bank.bankOffice.creditDepartment.bankCreditFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

public class BankCreditAvto implements CreditCreater {
    @Override
    public Credit create(BankOffice bankOffice, Client client, int sum, String type, int creditTerm) {
        if (sum <= 300000){
            return new BankCreditConsumer().create(bankOffice,client,sum,type,creditTerm);
        }else if (sum > 300000 && sum <= 1000000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Авто 1").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(17.1).setIdHolder(client.getId()).calckPaymentMounth(sum,17.1,creditTerm).build();
            return creditCons;
        }else if (sum > 1000000 && sum <= 1300000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Авто 2").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(14.9).setIdHolder(client.getId()).calckPaymentMounth(sum,14.9,creditTerm).build();
            return creditCons;
        }else if (sum > 1300000 && sum <= 1700000 ){
            Credit creditCons = new Credit.Builder().setCreditName( "Авто 3").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(12.8).setIdHolder(client.getId()).calckPaymentMounth(sum,12.8,creditTerm).build();
            return creditCons;
        }else if (sum > 1700000 && sum <= 2500000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Авто 4").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(9.9).setIdHolder(client.getId()).calckPaymentMounth(sum,9.9,creditTerm).build();
            return creditCons;
        }else if (sum > 2500000 && sum <= 5000000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Авто 5").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(6.89).setIdHolder(client.getId()).calckPaymentMounth(sum,6.89,creditTerm).build();
            return creditCons;
        }else {
            return null;
        }
    }
}

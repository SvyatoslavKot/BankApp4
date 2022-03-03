package com.company.bank.bankOffice.bankFactory.creditDepartment.bankCreditFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

public class BankCreditCard implements CreditCreater {
    @Override
    public Credit create(BankOffice bankOffice, Client client, int sum, String type, int creditTerm) {
        if (sum <= 15000){
            Credit creditCons = new Credit.Builder().setCreditName("Кредитная_карта_1").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(27.99).setIdHolder(client.getId()).calckPaymentMounth(sum,27.99,creditTerm).build();
            return creditCons;
        }else if (sum > 15000 && sum <= 30000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Кредитная_карта_2").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(19.99).setIdHolder(client.getId()).calckPaymentMounth(sum,19.99,creditTerm).build();
            return creditCons;
        }else if (sum > 30000 && sum <= 50000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Кредитная_карта_3").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(15.9).setIdHolder(client.getId()).calckPaymentMounth(sum,15.9,creditTerm).build();
            return creditCons;
        }else if (sum > 50000 && sum <= 100000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Кредитная_карта_4").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(14.8).setIdHolder(client.getId()).calckPaymentMounth(sum,14.8,creditTerm).build();
            return creditCons;
        }else if (sum > 100000 && sum <= 150000 ){
            Credit creditCons = new Credit.Builder().setCreditName("Кредитная_карта_5").setCreditTerm(creditTerm)
                    .setAmount(sum).setPtc(12.9).setIdHolder(client.getId()).calckPaymentMounth(sum,12.9,creditTerm).build();
            return creditCons;
        }else if (sum > 150000 ){
            return new BankCreditConsumer().create(bankOffice,client,sum,type,creditTerm);
        }else {
            return null;
        }
    }
}

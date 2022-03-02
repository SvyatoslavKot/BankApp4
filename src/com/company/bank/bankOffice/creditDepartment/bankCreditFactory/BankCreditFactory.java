package com.company.bank.bankOffice.creditDepartment.bankCreditFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

public class BankCreditFactory {
    public Credit def (){
        return new Credit.Builder().build();
    }
    public Credit create (BankOffice bankOffice, Client client, int sum, String type, int creditTerm){
        switch (type) {
            case "Потребительский" : return new BankCreditConsumer().create(bankOffice,client,sum,type,creditTerm);
            case "Автокредит" : return  new BankCreditAvto().create(bankOffice,client,sum,type,creditTerm);
            case "Ипотека" : return  new BankCreditHypothec().create(bankOffice, client, sum, type,creditTerm);
            case "Кредитная карта" : return new BankCreditCard().create(bankOffice, client, sum, type, creditTerm);
            default: return null;
        }
    }

}

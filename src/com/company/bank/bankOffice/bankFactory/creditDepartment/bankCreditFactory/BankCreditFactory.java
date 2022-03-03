package com.company.bank.bankOffice.bankFactory.creditDepartment.bankCreditFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.BankProductFactory;
import com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory.AccountMoney;
import com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory.Insurance;

public class BankCreditFactory implements BankProductFactory {

    public Credit create (BankOffice bankOffice, Client client, int sum, String type, int creditTerm){
        switch (type) {
            case "Потребительский" : return new BankCreditConsumer().create(bankOffice,client,sum,type,creditTerm);
            case "Автокредит" : return  new BankCreditAvto().create(bankOffice,client,sum,type,creditTerm);
            case "Ипотека" : return  new BankCreditHypothec().create(bankOffice, client, sum, type,creditTerm);
            case "Кредитная карта" : return new BankCreditCard().create(bankOffice, client, sum, type, creditTerm);
            default: return null;
        }
    }

    @Override
   public AccountMoney create(BankOffice bankOffice, Client client, String type, String level) {
        return null;
    }
    @Override
    public Insurance create(Client client, BankOffice bankOffice, String type, int insuranceValue, int term) {
        return null;
    }

}

package com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.BankProductFactory;
import com.company.bank.bankOffice.bankFactory.creditDepartment.bankCreditFactory.Credit;
import com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory.Insurance;

public class AccountFactory implements BankProductFactory {

    @Override
    public AccountMoney create(BankOffice bankOffice, Client client, String type, String level){
        switch (type) {
            case "СберКарта": return new AccountMoneySberCard().create(bankOffice,client,level);
            case "Молодежный": return new AccountMoneyYoung().create(bankOffice,client,level);
            case "Travel": return new AccountMoneyTravel().create(bankOffice, client, level);
            default:
                System.out.println("Неверная операция");
        }
        return null;
    }


    @Override
    public Credit create(BankOffice bankOffice, Client client, int sum, String type, int creditTerm) {
        return null;
    }
    @Override
    public Insurance create(Client client, BankOffice bankOffice, String type, int insuranceValue, int term) {
        return null;
    }
}

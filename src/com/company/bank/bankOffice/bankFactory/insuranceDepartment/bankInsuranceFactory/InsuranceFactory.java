package com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.BankProductFactory;
import com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory.AccountMoney;
import com.company.bank.bankOffice.bankFactory.creditDepartment.bankCreditFactory.Credit;

public class InsuranceFactory implements BankProductFactory {
    @Override
    public Insurance create(Client client, BankOffice bankOffice, String type, int insuranceValue, int term) {
        switch (type) {
            case "Жизнь":
                return new InsuranceLive().create(client, bankOffice, insuranceValue, term);
            case "Имущество":
                return new InsuranceProperty().create(client, bankOffice, insuranceValue, term);
        }
        return null;
    }


    @Override
    public Credit create(BankOffice bankOffice, Client client, int sum, String type, int creditTerm) {
        return null;
    }
    @Override
    public AccountMoney create(BankOffice bankOffice, Client client, String type, String level) {
        return null;
    }
}

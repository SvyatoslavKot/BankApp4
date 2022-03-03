package com.company.bank.bankOffice.bankFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory.AccountMoney;
import com.company.bank.bankOffice.bankFactory.creditDepartment.bankCreditFactory.Credit;
import com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory.Insurance;

public interface BankProductFactory {
    Credit create (BankOffice bankOffice, Client client, int sum, String type, int creditTerm);
    AccountMoney create(BankOffice bankOffice, Client client, String type, String level);
    Insurance create(Client client, BankOffice bankOffice, String type, int insuranceValue, int term);
}

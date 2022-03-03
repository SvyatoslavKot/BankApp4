package com.company.bank.bankOffice.bankFactory.creditDepartment.bankCreditFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

public interface CreditCreater {
    Credit create(BankOffice bankOffice, Client client, int sum, String type, int creditTerm);
}

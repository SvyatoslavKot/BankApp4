package com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

public interface InsuranceCreater {
   Insurance create(Client client, BankOffice bankOffice, int insuranceValue, int term);
}

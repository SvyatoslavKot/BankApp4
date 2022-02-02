package com.company.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;

public abstract class Insurance {
  abstract void openInsurance(Client client, BankOffice bankOffice, int insuranceValue, double price, int term);
}
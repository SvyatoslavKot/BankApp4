package com.company.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;

public abstract class Insurance {
  abstract void openInsurance(Client client, BankOffice bankOffice,String nameInsurance, int insuranceValue, int price, int term);
}
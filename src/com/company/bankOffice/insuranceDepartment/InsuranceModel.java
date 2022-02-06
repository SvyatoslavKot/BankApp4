package com.company.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.bankOffice.BankOffice;

public abstract class InsuranceModel {
  abstract String openInsurance(Client client, BankOffice bankOffice, int insuranceValue, double price, int term);

  public abstract int compareTo(Insurance o1, Insurance o2);
}
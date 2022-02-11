package com.company.bank.bankOffice.BankService;

import com.company.Client;
import com.company.bank.bankOffice.creditDepartment.CreditController;

public interface AccontCreditOperation {
    void viewMoneyAmountCredit(CreditController a);
    void paymentCreditCash(Client cash, CreditController a, int money);

}
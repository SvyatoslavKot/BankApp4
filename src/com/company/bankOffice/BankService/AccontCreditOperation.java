package com.company.bankOffice.BankService;

import com.company.Client;
import com.company.bankOffice.creditDepartment.CreditController;

public interface AccontCreditOperation {
    void viewMoneyAmountCredit(CreditController a);
    void paymentCreditCash(Client cash, CreditController a, int money);

}
package com.company.bankOffice;

import com.company.Client;
import com.company.bankOffice.creditDepartment.CreditAccount;

public interface AccontCreditOperation {
    void viewMoneyAmountCredit(CreditAccount a);
    void paymentCreditCash(Client cash, CreditAccount a, int money);

}
package com.company.bankOffice.BankService;

import com.company.Client;
import com.company.bankOffice.accountManagementDepartment.DebitAccountModel;
import com.company.bankOffice.creditDepartment.CreditAccount;

public interface AccountDebitOperation {
    void putCashOnDebitAccount(Client cash, DebitAccountModel debitAccountModel, int money);
    void viewMoneyOnDebit(DebitAccountModel a);
    void getCashOnDebit(Client client, DebitAccountModel debitAccountModel, int money);
    void paymentCreditDebit(Client client, DebitAccountModel debitAccount, CreditAccount creditAccount, int money);
    void moneyTransfer(Client client, DebitAccountModel debitAccountSender, DebitAccountModel debitAccountAddressee, int money);




}
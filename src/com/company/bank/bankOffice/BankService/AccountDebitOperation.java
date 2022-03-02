package com.company.bank.bankOffice.BankService;

import com.company.Client;
import com.company.bank.bankOffice.accountManagementDepartment.AccountMoney;

public interface AccountDebitOperation {
    void putCashOnDebitAccount(Client cash, AccountMoney debitAccountModel, int money);
    void viewMoneyOnDebit(AccountMoney a);
    void getCashOnDebit(Client client, AccountMoney debitAccountModel, int money);
   // void paymentCreditDebit(Client client, AccountMoney debitAccount, CreditController creditAccount, int money);
    void moneyTransfer(Client client, AccountMoney debitAccountSender, AccountMoney debitAccountAddressee, int money);

}
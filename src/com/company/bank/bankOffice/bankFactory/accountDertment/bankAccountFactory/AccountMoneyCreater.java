package com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

public interface AccountMoneyCreater {
    AccountMoney create(BankOffice bankOffice, Client client,String level );
}

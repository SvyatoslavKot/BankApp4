package com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

public class AccountMoneySberCard implements  AccountMoneyCreater {

    @Override
    public AccountMoney create(BankOffice bankOffice, Client client, String level) {
        if (level.equals("ligt")) {
            return new AccountMoney.Builder().setNameAccount("Sber_Light")
                    .setPayment(150).setCashBack(1.2).setCreditTerm(24).setIdHolder(client.getId()).build();
        } else if (level.equals("Standard")) {
            return new AccountMoney.Builder().setNameAccount("Sber_Standart")
                    .setPayment(350).setCashBack(3.2).setCreditTerm(36).setIdHolder(client.getId()).build();
        } else if (level.equals("Gold")) {
            return new AccountMoney.Builder().setNameAccount("Sber_Gold")
                    .setPayment(550).setCashBack(5.2).setCreditTerm(60).setIdHolder(client.getId()).build();
        } else {
            System.out.println("Неверная операция.");
            return null;
        }
    }
}

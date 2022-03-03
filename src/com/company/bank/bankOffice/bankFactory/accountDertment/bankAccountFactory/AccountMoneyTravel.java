package com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

public class AccountMoneyTravel implements AccountMoneyCreater {
    @Override
    public AccountMoney create(BankOffice bankOffice, Client client, String level) {
        if (level.equals("ligt")) {
            return new AccountMoney.Builder().setNameAccount("Yong_Light")
                    .setPayment(400).setCashBack(3.2).setCreditTerm(12).setIdHolder(client.getId()).build();
        } else if (level.equals("Standard")) {
            return new AccountMoney.Builder().setNameAccount("Young_Standart")
                    .setPayment(600).setCashBack(6.2).setCreditTerm(24).setIdHolder(client.getId()).build();
        } else if (level.equals("Gold")) {
            return new AccountMoney.Builder().setNameAccount("Young_Gold")
                    .setPayment(777).setCashBack(8.5).setCreditTerm(36).setIdHolder(client.getId()).build();
        } else {
            System.out.println("Неверная операция.");
            return null;
        }
    }
}

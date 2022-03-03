package com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

public class AccountMoneyYoung implements AccountMoneyCreater {
    @Override
    public AccountMoney create(BankOffice bankOffice, Client client, String level) {
        if (level.equals("ligt")) {
            return new AccountMoney.Builder().setNameAccount("Yong_Light")
                    .setPayment(0).setCashBack(1.2).setCreditTerm(12).setIdHolder(client.getId()).build();
        } else if (level.equals("Standard")) {
            return new AccountMoney.Builder().setNameAccount("Young_Standart")
                    .setPayment(130).setCashBack(3.2).setCreditTerm(24).setIdHolder(client.getId()).build();
        } else if (level.equals("Gold")) {
            return new AccountMoney.Builder().setNameAccount("Young_Gold")
                    .setPayment(250).setCashBack(5.5).setCreditTerm(24).setIdHolder(client.getId()).build();
        } else {
            System.out.println("Неверная операция.");
            return null;
        }
    }
}

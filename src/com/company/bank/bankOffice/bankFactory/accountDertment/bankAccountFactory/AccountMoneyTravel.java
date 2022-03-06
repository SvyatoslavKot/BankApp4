package com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.ProductBuilder;

public class AccountMoneyTravel implements AccountMoneyCreater {
    @Override
    public AccountMoney create(BankOffice bankOffice, Client client, String level) {
        if (level.equals("ligt")) {
            return new ProductBuilder.Builder().setNameProduct("Yong_Light")
                    .setPayment(400).setCashBack(3.2).setTerm(12).setClientId(client.getId()).buildAccount();
        } else if (level.equals("Standard")) {
            return new ProductBuilder.Builder().setNameProduct("Young_Standart")
                    .setPayment(600).setCashBack(6.2).setTerm(24).setClientId(client.getId()).buildAccount();
        } else if (level.equals("Gold")) {
            return new ProductBuilder.Builder().setNameProduct("Young_Gold")
                    .setPayment(777).setCashBack(8.5).setTerm(36).setClientId(client.getId()).buildAccount();
        } else {
            System.out.println("Неверная операция.");
            return null;
        }
    }
}

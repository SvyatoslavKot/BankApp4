package com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.ProductBuilder;

public class AccountMoneySberCard implements  AccountMoneyCreater {

    @Override
    public AccountMoney create(BankOffice bankOffice, Client client, String level) {
        if (level.equals("ligt")) {
            return new ProductBuilder.Builder().setNameProduct("Sber_Light")
                    .setPayment(150).setCashBack(1.2).setTerm(24).setClientId(client.getId()).buildAccount();
        } else if (level.equals("Standard")) {
            return new ProductBuilder.Builder().setNameProduct("Sber_Standart")
                    .setPayment(350).setCashBack(3.2).setTerm(36).setClientId(client.getId()).buildAccount();
        } else if (level.equals("Gold")) {
            return new ProductBuilder.Builder().setNameProduct("Sber_Gold")
                    .setPayment(550).setCashBack(5.2).setTerm(60).setClientId(client.getId()).buildAccount();
        } else {
            System.out.println("Неверная операция.");
            return null;
        }
    }
}

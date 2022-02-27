package com.company.bank.bankOffice.accountManagementDepartment;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

public class AccountMoneyController {
    public AccountMoney openDebit(Client client, BankOffice bankOffice, String type, String level) throws Exception {
        switch (type) {
            case "СберКарта":
                return openSberCard(bankOffice, client, level);
            case "Молодежный":
                return openSberYong(bankOffice, client, level);
            case "Travel":
                return openTravel(bankOffice, client, level);
            default:
                System.out.println("Неверная операция");
        }
        return null;

    }

    private AccountMoney openSberCard(BankOffice bankOffice, Client client, String level) throws Exception {
        if (level.equals("Light")) {
            return new AccountMoney("Сбер light", bankOffice, client, 0, 24, 150, 0);
        } else if (level.equals("Standard")) {
            return new AccountMoney("Сбер Standard", bankOffice, client, 0, 36, 390, 5.5);
        } else if (level.equals("Gold")) {
            return new AccountMoney("Сбер Gold", bankOffice, client, 0, 36, 500, 7.5);
        } else {
            throw new Exception("Неверная операция.");
            //System.out.println("Неверная операция.");
            //return null;
        }
    }

    private AccountMoney openSberYong(BankOffice bankOffice, Client client, String level) throws Exception {
        if (level.equals("Light")) {
            return new AccountMoney("Молодежный", bankOffice, client, 0, 24, 150, 0);
        } else if (level.equals("Standard")) {
            return new AccountMoney("Молодежный+", bankOffice, client, 0, 36, 220, 3.2);
        } else if (level.equals("Gold")) {
            return new AccountMoney("Молодежный Супер", bankOffice, client, 0, 36, 320, 5.2);
        } else {
            throw new Exception("Неверная операция.");
            //System.out.println("Неверная операция.");
            //return null;
        }
    }

    private AccountMoney openTravel(BankOffice bankOffice, Client client, String level) throws Exception {
        if (level.equals("Light")) {
            return new AccountMoney("Travel light", bankOffice, client, 0, 12, 200, 4.5);
        } else if (level.equals("Standard")) {
            return new AccountMoney("Travel Plus", bankOffice, client, 0, 24, 500, 7);
        } else if (level.equals("Gold")) {
            return new AccountMoney("Travel Gold", bankOffice, client, 0, 36, 700, 9.5);
        } else {
            throw new Exception("Неверная операция.");
            //System.out.println("Неверная операция.");
            //return null;
        }
    }
}

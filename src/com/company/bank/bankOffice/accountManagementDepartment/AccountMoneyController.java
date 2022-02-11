package com.company.bank.bankOffice.accountManagementDepartment;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;

import java.util.Scanner;

public class AccountMoneyController {
    AccountMoney debit = new AccountMoney();
    Scanner scanner = new Scanner(System.in);

    public void openDebit(Client client, BankOffice bankOffice) {
        System.out.println(client.getName() + " ввведи тип бановского счёта  \n" +
                "1 - Сберарта 2 - Молодежная 3- Travel");
        String type = scanner.nextLine();
        switch (type) {
            case "1":
                System.out.println(client.getName() + "Введите уровень карты: 1-light 2-medium 3-gold");
                int sum = scanner.nextInt();
                if (sum == 1) {
                    debit.openDebitAccount("Сберкарта light", 0, 24, client, bankOffice, 150, 3.5);
                } else if (sum == 2) {
                    debit.openDebitAccount("Сберкарта medium", 0, 36, client, bankOffice, 390, 5.5);
                } else if (sum == 3) {
                    debit.openDebitAccount("Сберкарта gold", 0, 36, client, bankOffice, 500, 7.5);
                } else {
                    System.out.println("Неверная операция.");
                }
                break;
            case "2":
                System.out.println(client.getName() + "Введите уровень карты: 1 2");
                int sum1 = scanner.nextInt();
                if (sum1 == 1) {
                    debit.openDebitAccount("Молодежная", 0, 12, client, bankOffice, 0, 0);
                } else if (sum1 == 2) {
                    debit.openDebitAccount("Молодежная +", 0, 24, client, bankOffice, 220, 3.2);
                } else {
                    System.out.println("Неверная операция");
                }
                break;
            case "3":
                System.out.println(client.getName() + "Введите уровень Travel карты: 1-light 2-Plus 3-gold");
                int sum2 = scanner.nextInt();
                if (sum2 == 1) {
                    debit.openDebitAccount("Travel light", 0, 12, client, bankOffice, 200, 4.5);
                } else if (sum2 == 2) {
                    debit.openDebitAccount("Travel Plus ", 0, 24, client, bankOffice, 500, 7.0);
                } else if (sum2 == 3) {
                    debit.openDebitAccount("Travel Gold", 0, 36, client, bankOffice, 700, 9.5);
                } else {
                    System.out.println("Неверная операция.");
                }
                break;

            default:
                System.out.println("Неверная операция");
        }

    }
}

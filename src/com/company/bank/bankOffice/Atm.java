package com.company.bank.bankOffice;

import com.company.Client;
import com.company.bank.bankOffice.BankService.AccontCreditOperation;
import com.company.bank.bankOffice.BankService.AccountDebitOperation;
import com.company.bank.bankOffice.BankService.PaymentOperation;
import com.company.bank.bankOffice.accountManagementDepartment.AccountMoney;
import com.company.bank.bankOffice.creditDepartment.CreditController;
import com.company.service.ClientService;
import com.company.service.DebitAccountService;

public class Atm implements AccountDebitOperation, PaymentOperation, AccontCreditOperation {
    DebitAccountService debitAccountService = new DebitAccountService();
    ClientService clientService = new ClientService();

    public void putCashOnDebitAccount(Client client, AccountMoney debitAccountModel, int money) {
        System.out.println("Положить наличку на счет " + money);
        clientService.giveCash(money, client);
        debitAccountService.putMoneyOnDebit(money, debitAccountModel);
    }
    public void viewMoneyOnDebit(AccountMoney a){
        System.out.println("Запросить баланс.");
        System.out.println("На счёте: " + a.getMoneyInAccount());
    }
    public void getCashOnDebit(Client client, AccountMoney debitAccountModel, int money){
        System.out.println("Снять со счёта " + money);
        client.setCash(money);
        debitAccountService.givMoneyDebit( money,debitAccountModel);

    }
    public void viewMoneyAmountCredit(CreditController a){
        System.out.println("Узнать сумму долга по кредите.");
        System.out.println("Долг составляет: " + a.getAmount());
    }
    public void paymentCreditCash(Client client, CreditController a, int money){
        System.out.println("Поожить на кредитный счет " + money + " руб.");
        clientService.giveCash(money, client);
        a.putMoneyOnCreditAmount(money);
    }
    public void paymentCreditDebit(Client client, AccountMoney debitAccount, CreditController creditAccount, int money){
        debitAccountService.givMoneyDebit(money, debitAccount);
        creditAccount.putMoneyOnCreditAmount(money);
        System.out.println(client.getName() + " перевел на кредитный счёт " + money + " рублей.");
    }
    public void moneyTransfer(Client client, AccountMoney debitAccountSender, AccountMoney debitAccountAddressee, int money){
        debitAccountService.givMoneyDebit(money, debitAccountSender);
        debitAccountService.putMoneyOnDebit(money, debitAccountAddressee);
        System.out.println(client.getName() + " перевел  с счета " + debitAccountSender.getAccountNumber() + money + " рублей на счёт номер " + debitAccountAddressee.getAccountNumber());
    }

    @Override
    public void payForComunalServis(Client client, int money) {
        System.out.println("Оплатить комунальные услугу в кассе.");
        clientService.giveCash(money, client);
    }

    public void paymentMobilPhoneCash(Client client, int money, String mobilPhone) {
        clientService.giveCash(money, client);
        System.out.println("На номер " + mobilPhone+ " зачислинно " + money + " рублей.");
    }
    public  void paymentMobilPhoneDebitCard( Client client, int money, String mobilPhone) {
        clientService.giveCash(money, client);
        System.out.println("На номер " + mobilPhone+ " зачислинно " + money + " рублей.");
    }
}
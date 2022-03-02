package com.company.bank.bankOffice;

import com.company.Client;
import com.company.bank.bankOffice.BankService.AccontCreditOperation;
import com.company.bank.bankOffice.BankService.AccountDebitOperation;
import com.company.bank.bankOffice.BankService.PaymentOperation;
import com.company.bank.bankOffice.accountManagementDepartment.AccountMoney;
import com.company.exception.MoneyAccountException;
import com.company.service.ClientService;
import com.company.service.DebitAccountService;

public class Atm {
    DebitAccountService debitAccountService = new DebitAccountService();
    ClientService clientService = new ClientService();
    private AccountMoney accountMoneyUser = new AccountMoney();
    private AccountMoney accountMoneyAdress = new AccountMoney();


    public AccountMoney getAccountMoneyUser() {
        return accountMoneyUser;
    }
    public void setAccountMoneyUser(AccountMoney accountMoneyUser) {
        this.accountMoneyUser = accountMoneyUser;
    }
    public AccountMoney getAccountMoneyAdress() {
        return accountMoneyAdress;
    }
    public void setAccountMoneyAdress(AccountMoney accountMoneyAdress) {
        this.accountMoneyAdress = accountMoneyAdress;
    }

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






    public boolean moneyTransfer( AccountMoney debitAccountSender, AccountMoney debitAccountAddressee, int money)throws MoneyAccountException{
        if (debitAccountSender.getMoneyInAccount()>= money){
            debitAccountSender.minusMoney(money);
            debitAccountAddressee.plusMoney(money);
            return true;
        }else {
            System.out.println("Недостаточно средств на карте");
            return false;
        }
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
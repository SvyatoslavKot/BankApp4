package com.company.bank.bankOffice;

import com.company.Client;
import com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory.AccountMoney;
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

    public boolean putMoneyOnAccount(BankOffice bankOffice, AccountMoney accountMoney, int money) throws MoneyAccountException {
        Client client = bankOffice.getBankCollections().getClientHashMap().get(accountMoney.getIdHolder());
        if (client!= null && accountMoney!=null){
            if (client.getCash()>= money){
                client.minusCash(money);
                accountMoney.plusMoney(money);
                return true;
            }
        }return false;
    }
    public boolean withdrawMoneyOnAccount (BankOffice bankOffice, AccountMoney account, int money) throws MoneyAccountException{
        Client client = bankOffice.getBankCollections().getClientHashMap().get(account.getIdHolder());
        if (client!= null && account!= null){
            if (account.getMoneyInAccount()>= money){
                account.minusMoney(money);
                client.plusCash(money);
                return true;
            }
        }return false;
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

}
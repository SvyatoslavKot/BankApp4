package com.company.bank.bankOffice.accountManagementDepartment;


import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.service.GenerateAccountNumber;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountMoney extends AccountMoneyModel {
    private String nameAccount;
    private String accountNumber;
    private int moneyInAccount;
    private Date openingDate;
    private int creditTerm;
    private int payment;
    private double cashBack;
    private String idHolder;

    private GenerateAccountNumber generateAccountNumber = new GenerateAccountNumber();
    @Override
    void openDebitAccount(String nameCredit,int sum,int term, Client client, BankOffice bankOffice, int payment, double cashBack) {
        this.nameAccount = nameCredit;
        this.accountNumber = generateAccountNumber.accountNumber();
        this.moneyInAccount = sum;
        this.openingDate = new Date();
        this.creditTerm = term;
        this.payment = payment;
        this.cashBack = cashBack;
        this.idHolder = client.getId();

        bankOffice.getBankCollections().getAccountList().add(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.println("Для "+ client.getName() + " создан " + nameAccount  +
                "\n________________ИНФОРМАЦИЯ__________________" +
                "\nномер счёта: " + accountNumber +
                "\nдата открытия: " + dateFormat.format(openingDate) +
                "\nсроком: "+ creditTerm +" мес."+
                "\nбаланс счёта: "+ moneyInAccount+
                "\nежемесчная плата за обслуживание: "+ payment +
                "\ncashBack по карте: " + cashBack +
                "\n____________________________________________");
    }

    public int getMoneyInAccount() {
        return moneyInAccount;
    }
    public void setMoneyInAccount(int moneyInAccount) {
        this.moneyInAccount = moneyInAccount;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

}
package com.company.bankOffice.accountManagementDepartment;


import com.company.Client;
import com.company.bankOffice.BankOffice;
import com.company.service.GenerateAccountNumber;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DebitAccountModel extends  DebitAccount{
    private String nameAccount;
    private String accountNumber;
    private int moneyInAccount;
    private Date openingDate;
    private int creditTerm;
    private int payment;
    private double cashBack;

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

        bankOffice.getClientBankList().put(client.getPassport(),client.getName());
        client.getDebitAccount().put(this.accountNumber, this.nameAccount);
        client.getListOfAccounts().put(this.accountNumber, this.nameAccount);

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
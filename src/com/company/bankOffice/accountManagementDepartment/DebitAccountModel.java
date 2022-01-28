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

    private GenerateAccountNumber generateAccountNumber = new GenerateAccountNumber();


    @Override
    void openDebitAccount(Client client, BankOffice bankOffice) {
        this.nameAccount = "Дебетовый счет";
        this.accountNumber = generateAccountNumber.accountNumber();
        this.moneyInAccount = moneyInAccount;
        this.openingDate = new Date();
        this.creditTerm = 24;

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
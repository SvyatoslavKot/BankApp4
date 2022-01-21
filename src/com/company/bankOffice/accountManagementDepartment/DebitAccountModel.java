package com.company.bankOffice.accountManagementDepartment;


import com.company.Client;
import com.company.service.GenerateAccountNumber;

public class DebitAccountModel extends  DebitAccount{
    private String nameAccount;
    private String accountNumber;
    private int moneyInAccount;
    private String openingDate;
    private int creditTerm;

    private GenerateAccountNumber generateAccountNumber = new GenerateAccountNumber();


    @Override
    void openDebitAccount(Client client, String nameAccount, int moneyInAccount, int term) {
        this.nameAccount = nameAccount;
        this.accountNumber = generateAccountNumber.accountNumber();
        this.moneyInAccount = moneyInAccount;
        this.openingDate = openingDate;
        this.creditTerm = term;

        client.getDebitAccount().put(this.accountNumber, this.nameAccount);

        System.out.println("Для "+ client.getName() + " создан " + nameAccount  +
                "\n________________ИНФОРМАЦИЯ__________________" +
                "\nномер счёта: " + accountNumber +
                "\nдата открытия: " + openingDate +
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
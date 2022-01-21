package com.company.bankOffice.accountManagementDepartment;

public class BankMoneyOperation {


    public int putMoneyOnDebit (DebitAccountModel debit, int money){
        int a = 0;
        a = debit.getMoneyInAccount() + money;
        debit.setMoneyInAccount(a);
        return a;
    }

    public int givMoneyDebit (DebitAccountModel debitAccount, int money){
        int a = 0;
        if (debitAccount.getMoneyInAccount() >= money){
            a = debitAccount.getMoneyInAccount() - money;
            debitAccount.setMoneyInAccount(a);
            return debitAccount.getMoneyInAccount();
        }else{
            System.out.println("Недостаточно средств для операции.");
        }
        return debitAccount.getMoneyInAccount();
    }





}
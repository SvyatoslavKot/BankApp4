package com.company.service;

import com.company.bankOffice.accountManagementDepartment.DebitAccountModel;

public class DebitAccountService {
    public int putMoneyOnDebit (int money, DebitAccountModel debitAccountModel){
        int a = 0;
        a = debitAccountModel.getMoneyInAccount() + money;
        debitAccountModel.setMoneyInAccount(a);
        return debitAccountModel.getMoneyInAccount();
    }
    public int givMoneyDebit (int money, DebitAccountModel debitAccountModel){
        int a = 0;
        if (debitAccountModel.getMoneyInAccount() >= money){
            a = debitAccountModel.getMoneyInAccount() - money;
            debitAccountModel.setMoneyInAccount(a);
            return debitAccountModel.getMoneyInAccount();
        }else{
            System.out.println("Недостаточно средств для операции.");
        }
        return debitAccountModel.getMoneyInAccount();
    }
}
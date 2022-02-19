package com.company.bank.bankCentralOffice;


import com.company.Client;
import com.company.bank.bankOffice.Staff;
import com.company.bank.bankOffice.accountManagementDepartment.AccountMoney;
import com.company.service.ClientService;
import com.company.service.DebitAccountService;

public class ManagerSpecialAccountOperations extends Staff {
    public ManagerSpecialAccountOperations(String name, int age, String position, int tabNum, String dep) {
        super(name, age, position, tabNum, dep);
        this.clientService = clientService;
    }

    ClientService clientService = new ClientService();
    DebitAccountService debitAccountService = new DebitAccountService();

    public void getCashOnCard(Client client, AccountMoney debitAccountModel, int money){
        if (money>= 10000000){
            System.out.println("Снять со счёта " + money);
            clientService.takeCash(money,client);
            debitAccountService.givMoneyDebit(money, debitAccountModel);

        }else{
            System.out.println(" обратитесь в кассу банка, либо проведите операцию через банкомат.");
        }


    }

}
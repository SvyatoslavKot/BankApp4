package com.company.bankCentralOffice;


import com.company.Client;
import com.company.bankOffice.Staff;
import com.company.bankOffice.accountManagementDepartment.DebitAccountModel;
import com.company.service.ClientService;
import com.company.service.DebitAccountService;

public class ManagerSpecialAccountOperations extends Staff {
    public ManagerSpecialAccountOperations(String name, int age, String position, ClientService clientService) {
        super(name, age, position);
        this.clientService = clientService;
    }

    ClientService clientService = new ClientService();
    DebitAccountService debitAccountService = new DebitAccountService();

    public void getCashOnCard(Client client, DebitAccountModel debitAccountModel, int money){
        if (money>= 10000000){
            System.out.println("Снять со счёта " + money);
            clientService.takeCash(money,client);
            debitAccountService.givMoneyDebit(money, debitAccountModel);

        }else{
            System.out.println(" обратитесь в кассу банка, либо проведите операцию через банкомат.");
        }


    }

}
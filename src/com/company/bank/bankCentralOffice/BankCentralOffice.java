package com.company.bank.bankCentralOffice;


import com.company.bank.bankOffice.BankOffice;

import java.util.HashMap;

public class BankCentralOffice extends BankOffice {
    ManagerCustomerService managerCustomerService;
    ManagerSpecialAccountOperations managerSpecialAccountOperations;

    public BankCentralOffice(String nameBank) {
        super(nameBank);
        this.managerCustomerService = new ManagerCustomerService(null,0,null,44, " ");
        this.managerSpecialAccountOperations = new ManagerSpecialAccountOperations(null,0, null,44, " ");
    }



    HashMap<String,String> clientBankListCentral = new HashMap<>();

    @Override
    public String getNameBank() {
        return "центральный офис " + super.getNameBank();
    }

    public HashMap<String, String> getClientBankListCentral() {
        return clientBankListCentral;
    }
}
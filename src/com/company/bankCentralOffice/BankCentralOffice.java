package com.company.bankCentralOffice;


import com.company.bankOffice.BankOffice;

import java.util.HashMap;

public class BankCentralOffice extends BankOffice {

    //WaitingInLine waitingInLine = new WaitingInLine();

    public BankCentralOffice(String nameBank) {
        super(nameBank);
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
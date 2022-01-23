package com.company.bankCentralOffice;

import com.company.bankOffice.BankOffice;
import com.company.builder.BankCentralOfficeBuilder;

import java.util.HashMap;

public class BankCentralOffice extends BankOffice {

    private final BankCentralOfficeBuilder bankCentralOfficeBuilder;

    HashMap<String,String> clientBankListCentral = new HashMap<>();
    //WaitingInLine waitingInLine = new WaitingInLine();

    public BankCentralOffice(String nameBank) {
        super(nameBank);
        this.bankCentralOfficeBuilder= new BankCentralOfficeBuilder();
    }

    @Override
    public String getNameBank() {
        return "центральный офис " + super.getNameBank();
    }

    public HashMap<String, String> getClientBankListCentral() {
        return clientBankListCentral;
    }

    public BankCentralOfficeBuilder getBankCentralOfficeBuilder() {
        return bankCentralOfficeBuilder;
    }
}
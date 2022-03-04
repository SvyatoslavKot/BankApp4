package com.company.data;

import com.company.bank.bankOffice.BankOffice;

import java.io.IOException;

public class DBWriter {
    DBWriteAccountMoney bdWriteAccountMoney = DBWriteAccountMoney.getInstance();
    DBWriteInsurance bdWriteInsurance = DBWriteInsurance.getInstance();
    DBWriteCredit bdWriteCredit = DBWriteCredit.getInstance();
    DBWriteClient bdWriteClient = DBWriteClient.getInstance();
    private String dir = "src/com/company/resources/";

    public void write(BankOffice bankOffice, String packet) throws IOException {
        bdWriteClient.writeClient(bankOffice, dir + packet+"/clients.txt");
        bdWriteCredit.writeCredit(bankOffice,dir + packet + "/credits.txt");
        bdWriteInsurance.writeInsurance(bankOffice, dir + packet + "/insurances.txt");
        bdWriteAccountMoney.writeAcc(bankOffice, dir + packet + "/accounts.txt");
    }
}

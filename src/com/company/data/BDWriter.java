package com.company.data;

import com.company.bank.bankOffice.BankOffice;

import java.io.IOException;

public class BDWriter {
    BDWriteAccountMoney bdWriteAccountMoney = new BDWriteAccountMoney();
    BDWriteInsurance bdWriteInsurance = new BDWriteInsurance();
    BDWriteCredit bdWriteCredit = new BDWriteCredit();
    BdWriteClient bdWriteClient = new BdWriteClient();
    private String dir = "src/com/company/resources/";

    public void write(BankOffice bankOffice, String packet) throws IOException {
        bdWriteClient.writeClient(bankOffice, dir + packet+"/clients.txt");
        bdWriteCredit.writeCredit(bankOffice,dir + packet + "/credits.txt");
        bdWriteInsurance.writeInsurance(bankOffice, dir + packet + "/insurances.txt");
        bdWriteAccountMoney.writeAcc(bankOffice, dir + packet + "/accounts.txt");
    }
}

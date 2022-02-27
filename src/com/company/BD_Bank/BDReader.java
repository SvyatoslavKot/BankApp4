package com.company.BD_Bank;

import com.company.bank.bankOffice.BankOffice;

public class BDReader {
    BdReadClient bdReadClient = new BdReadClient();
    BDReadAccountMoney bdReadAccountMoney = new BDReadAccountMoney();
    BDReadInsurance bdReadInsurance = new BDReadInsurance();
    BDReadCredit bdReadCredit = new BDReadCredit();
    private String dir = "src/com/company/BD_Bank/resources/";

    public void bdRead (BankOffice bankOffice, String packet){
        bdReadClient.readBD(bankOffice,dir+packet+"/clients.txt");
        bdReadAccountMoney.readBD(bankOffice, dir+packet+"/accounts.txt");
        bdReadCredit.readBD(bankOffice,dir+packet+"/credits.txt");
        bdReadInsurance.readBD(bankOffice,dir+packet+"/insurances.txt");
    }
}

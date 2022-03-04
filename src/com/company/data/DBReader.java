package com.company.data;

import com.company.bank.bankOffice.BankOffice;

public class DBReader {
    DBReadClient bdReadClient = DBReadClient.getInstance();
    DBReadAccountMoney bdReadAccountMoney = DBReadAccountMoney.getInstance();
    DBReadInsurance bdReadInsurance = DBReadInsurance.getInstance();
    DBReadCredit bdReadCredit = DBReadCredit.getInstance();
    private String dir = "src/com/company/resources/";

    public void bdRead (BankOffice bankOffice, String packet){
        bdReadClient.readBD(bankOffice,dir+packet+"/clients.txt");
        bdReadAccountMoney.readBD(bankOffice, dir+packet+"/accounts.txt");
        bdReadCredit.readBD(bankOffice,dir+packet+"/credits.txt");
        bdReadInsurance.readBD(bankOffice,dir+packet+"/insurances.txt");
    }

}

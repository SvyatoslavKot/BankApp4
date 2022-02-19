package com.company.BD_Bank;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.accountManagementDepartment.AccountMoney;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BDWriteAccountMoney {
    private String CLIENT_MAPA = "com.company.BD_Bank.clients.txt";
    AccountMoney accountMoney;
    public void writeAcc (BankOffice bankOffice, String fileBD) throws IOException {
        ArrayList<AccountMoney> AccountList = bankOffice.getBankCollections().getAccountList();
        for (AccountMoney am:AccountList) {
            accountMoney = am;
            try (FileWriter fileWriter = new FileWriter(fileBD, true)) {

                fileWriter.write("name:" + accountMoney.getNameAccount() + " ");
                fileWriter.write("number:" + accountMoney.getAccountNumber() + " ");
                fileWriter.write("moneyIn:" + accountMoney.getMoneyInAccount() + " ");
                //fileWriter.write("date:"+accountMoney.getOpeningDate()+" ");
                fileWriter.write("term:" + accountMoney.getCreditTerm() + " ");
                fileWriter.write("payment:" + accountMoney.getPayment() + " ");
                fileWriter.write("cashBack:" + accountMoney.getCashBack() + " ");
                fileWriter.write("idHolder:" + accountMoney.getIdHolder() + " ");
                fileWriter.write("\n");

                fileWriter.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.company.data;

import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory.AccountMoney;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.currentThread;

public class DBWriteAccountMoney {

    private static DBWriteAccountMoney writeAccountMoney;

    private DBWriteAccountMoney() {
    }

    public static DBWriteAccountMoney getInstance(){
        if(writeAccountMoney == null){
            writeAccountMoney = new DBWriteAccountMoney();
        }return writeAccountMoney;
    }

    AccountMoney accountMoney;
    public void writeAcc (BankOffice bankOffice, String fileBD) throws IOException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t = currentThread();
                System.out.println(t.getName()+ " - запись коллекции счетов в txt");
                try (FileWriter fw = new FileWriter(fileBD)){
                    fw.write("");
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                        fileWriter.write("pin:" + accountMoney.getPin() + " ");
                        fileWriter.write("\n");

                        fileWriter.flush();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

    }
}

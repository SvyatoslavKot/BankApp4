package com.company.data;

import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.creditDepartment.bankCreditFactory.Credit;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DBWriteCredit {
    private  static DBWriteCredit bdWriteCredit;

    private DBWriteCredit() {
    }

    public static DBWriteCredit getInstance(){
        if(bdWriteCredit == null){
            bdWriteCredit = new DBWriteCredit();
        }return bdWriteCredit;
    }

    private String dir = "src/com/company/BD_Bank/resources/";
    public void writeCredit (BankOffice bankOffice, String fileBD){
        try (FileWriter fw = new FileWriter(fileBD)){
            fw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Credit> creditList = bankOffice.getBankCollections().getCreditList();
        for (Credit credit:creditList){
            try (FileWriter fileWriter  =new FileWriter(fileBD, true)) {

                fileWriter.write("name:"+credit.getCreditName()+" ");
                fileWriter.write("number:"+credit.getAccountNumber()+" ");
                fileWriter.write("amount:"+credit.getAmount()+" ");
                //fileWriter.write("date:"+credit.getOpeningDate()+" ");
                fileWriter.write("percent:"+credit.getPtc()+" ");
                fileWriter.write("payment:"+credit.getPaymentMonth()+" ");
                fileWriter.write("term:"+credit.getCreditTerm()+" ");
                fileWriter.write("idHolder:"+credit.getIdHolder()+" ");
                fileWriter.write("\n");

                fileWriter.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

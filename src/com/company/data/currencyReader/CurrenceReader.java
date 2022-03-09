package com.company.data.currencyReader;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.creditDepartment.bankCreditFactory.Credit;
import com.company.data.DBReadCredit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class CurrenceReader {
    Currence currence = new Currence();

    public void readBD(Currence currences, String filebd) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filebd))) {
            String currentLine = " ";
            while (null != (currentLine = bufferedReader.readLine())) {

                getValue(currence, currentLine);

            }
    } catch (IOException e) {
            e.printStackTrace();
        }
        currences.setUs(currence.getUs());
        currences.setEu(currence.getEu());
        currences.setCny(currence.getCny());
    }
    private void getValue(Currence currence, String s){
            if ( s!= null && s.contains("us/rub")){
                String t = s.split(":")[1];
               // System.out.println(t);
                currence.setUs(t);
               getCurrence().setUs(t);

        }else if ( s!= null && s.contains("eu/rub")){
                String t = s.split(":")[1];
               // System.out.println(t);
                currence.setEu(t);
                getCurrence().setEu(t);
        }else if  (s!= null && s.contains("cny/rub")){
            String t = s.split(":")[1];
           // System.out.println(t);
                currence.setCny(t);
            getCurrence().setCny(t);
        }
    }


    public Currence getCurrence() {
        return currence;
    }

    public void setCurrence(Currence currence) {
        this.currence = currence;
    }
}

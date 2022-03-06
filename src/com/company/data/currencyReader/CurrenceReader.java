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


    public String readBD(String currence, String filebd) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader( filebd))) {
            String currentLine = " ";
            while (null != (currentLine = bufferedReader.readLine())) {
                if (currence.equals("us")){
                    System.out.println(getUS(currentLine));
                    return  getUS(currentLine);
                }else if (currence.equals("eu")){
                    System.out.println(getEU(currentLine));
                    return  getEU(currentLine);
                }else if (currence.equals("cny")){
                    System.out.println(getCNY(currentLine));
                    return  getCNY(currentLine);
                }
            }
    } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getUS(String s) {
        if ( s!= null && s.contains("us/rub")){
            return  s.split("us/rub:")[1];
        }
        return null;
    }
    private String getEU(String s) {
        if ( s!= null && s.contains("eu/rub:")){
            return  s.split("eu/rub:")[1];
        }
        return null;
    }
    private String getCNY(String s) {
        if ( s!= null && s.contains("cny/rub:")){
            return  s.split("cny/rub:")[1];
        }
        return null;
    }

}

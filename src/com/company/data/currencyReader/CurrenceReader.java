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

public class CurrenceReader extends Thread {
    Currence currence = Currence.getInstance();
    @Override
    public synchronized void run() {
        System.out.println(currentThread().getName()+ " начал работу");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/company/resources/BankApp/currence.txt"))) {
            String currentLine = " ";
            while (null != (currentLine = bufferedReader.readLine())) {
                getValue(currence, currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(currentThread().getName()+ "Закончил работу");
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
}

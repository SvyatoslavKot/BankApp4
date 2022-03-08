package com.company.data;

import com.company.bank.bankOffice.BankOffice;

import com.company.bank.bankOffice.bankFactory.creditDepartment.bankCreditFactory.Credit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Thread.currentThread;

public class DBReadCredit {
    private ArrayList<Credit> creditList = new ArrayList<>();
    private String creditName ;
    private String accountNumber ;
    private int amount ;
    private double ptc ;
    private Date openingDate;
    private int creditTerm;
    private double paymentMonth;
    private String idHolder;

    Credit credit;

    private  static DBReadCredit bdReadCredit;

    private DBReadCredit() {
    }

    public static DBReadCredit getInstance(){
        if(bdReadCredit == null){
            bdReadCredit = new DBReadCredit();
        }return bdReadCredit;
    }

    public void readBD(BankOffice bankOffice, String filebd) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t = currentThread();
                System.out.println(t.getName()+ " - чтение списка кредитов из txt");
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader( filebd))) {
                    String currentLine = " ";
                    while (null != (currentLine = bufferedReader.readLine())) {
                        credit = convertStringToCredit(currentLine);
                        creditList.add(credit);
                    }
                    bankOffice.getBankCollections().getCreditList().removeAll(bankOffice.getBankCollections().getCreditList());
                    bankOffice.getBankCollections().getCreditList().addAll(creditList);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    System.out.println("Не удалось преобразовать строку в Integer");
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();

    }

    public Credit convertStringToCredit(String currentLine) {
        String[] sp = currentLine.split(" ");
        for (String s : sp) {
            nameSet(s);
            numberSet(s);
            amountSet(s);
            ptcSet(s);
            paymentSet(s);
            termSet(s);
            idHolderdSet(s);
        }
        return  new Credit.Builder().setCreditName(creditName).setCreditTerm(creditTerm)
                .setAmount(amount).setPtc(ptc).setIdHolder(idHolder).setPaymentMouth(paymentMonth).build();
    }
    private void nameSet(String s) {
        if (s != null && s.contains("name:")) {
            this.creditName = s.split(":")[1];
        }
    }
    private void numberSet(String s) {
        if (s != null && s.contains("number:")) {
            this.accountNumber = s.split(":")[1];
        }
    }
    private void amountSet(String s) {
        if ( s!= null && s.contains("amount:")){
            this.amount = Integer.parseInt(s.split(":")[1]);
        }
    }
    private void ptcSet(String s) {
        if ( s!= null && s.contains("percent:")){
          this.ptc = Double.parseDouble(s.split(":")[1]);
        }
    }
    private void paymentSet(String s) {
        if ( s!= null && s.contains("payment:")){
            this.paymentMonth  = Double.parseDouble(s.split(":")[1]);
        }
    }
    private void termSet(String s) {
        if ( s!= null && s.contains("term:")){
            this.creditTerm = Integer.parseInt(s.split(":")[1]);
        }
    }
    private void idHolderdSet(String s) {
        if ( s!= null && s.contains("idHolder:")){
            this.idHolder = s.split(":")[1];
        }
    }
}


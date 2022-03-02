package com.company.data;

import com.company.bank.bankOffice.BankOffice;

import com.company.bank.bankOffice.creditDepartment.bankCreditFactory.Credit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class BDReadCredit  {
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
    private String dir = "src/com/company/BD_Bank/resources/";
    public void readBD(BankOffice bankOffice, String filebd) {
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

    public Credit convertStringToCredit(String currentLine) {
        String[] sp = currentLine.split(" ");
        for (String s : sp) {
            getNameAndSet(s);
            getNumberAndSet(s);
            getAmountAndSet(s);
            getPtcAndSet(s);
            getPaymentAndSet(s);
            getTermAndSet(s);
            getIdHolderAndSet(s);
        }
        return  new Credit.Builder().setCreditName(creditName).setCreditTerm(creditTerm)
                .setAmount(amount).setPtc(ptc).setIdHolder(idHolder).setPaymentMouth(paymentMonth).build();
    }

    private void getNameAndSet(String s) {
        if (s != null && s.contains("name:")) {
            setCreditName(s.split(":")[1]);
        }
    }

    private void getNumberAndSet(String s) {
        if (s != null && s.contains("number:")) {
            setAccountNumber(s.split(":")[1]);
        }
    }

    private void getAmountAndSet(String s) {
        if ( s!= null && s.contains("amount:")){
            setAmount(Integer.parseInt(s.split(":")[1]));
        }
    }

    private void getPtcAndSet(String s) {
        if ( s!= null && s.contains("percent:")){
           setPtc(Double.parseDouble(s.split(":")[1]));
        }
    }

    private void getPaymentAndSet(String s) {
        if ( s!= null && s.contains("payment:")){
            setPaymentMonth(Double.parseDouble(s.split(":")[1]));
        }
    }

    private void getTermAndSet(String s) {
        if ( s!= null && s.contains("term:")){
            setCreditTerm(Integer.parseInt(s.split(":")[1]));
        }
    }

    private void getIdHolderAndSet(String s) {
        if ( s!= null && s.contains("idHolder:")){
            setIdHolder(s.split(":")[1]);
        }
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPtc(double ptc) {
        this.ptc = ptc;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public void setPaymentMonth(double paymentMonth) {
        this.paymentMonth = paymentMonth;
    }

    public void setIdHolder(String idHolder) {
        this.idHolder = idHolder;
    }
}


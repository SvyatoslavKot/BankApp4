package com.company.BD_Bank;

import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.creditDepartment.Credit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BDReadCredit {
    private ArrayList<Credit> creditList = new ArrayList<>();
    Credit credit;
    private String dir = "src/com/company/BD_Bank/resources/";
    public void readBD(BankOffice bankOffice, String filebd) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader( filebd))) {
            String currentLine = " ";
            while (null != (currentLine = bufferedReader.readLine())) {
                credit = convertStringToCredit(currentLine);
                creditList.add(credit);
            }
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
        Credit credit1 = new Credit();
        for (String s : sp) {
            getNameAndSet(s, credit1);
            getNumberAndSet(s, credit1);
            getAmountAndSet(s, credit1);
            getPtcAndSet(s, credit1);
            getPaymentAndSet(s, credit1);
            getTermAndSet(s, credit1);
            getIdHolderAndSet(s, credit1);
        }
        return credit1;
    }

    private void getNameAndSet(String s, Credit credit) {
        if (s != null && s.contains("name:")) {
            credit.setCreditName(s.split(":")[1]);
        }
    }

    private void getNumberAndSet(String s, Credit credit) {
        if (s != null && s.contains("number:")) {
            credit.setAccountNumber(s.split(":")[1]);
        }
    }

    private void getAmountAndSet(String s, Credit credit) {
        if ( s!= null && s.contains("amount:")){
            credit.setAmount(Integer.parseInt(s.split(":")[1]));
        }
    }

    private void getPtcAndSet(String s, Credit credit) {
        if ( s!= null && s.contains("percent:")){
            credit.setPtc(Double.parseDouble(s.split(":")[1]));
        }
    }

    private void getPaymentAndSet(String s, Credit credit) {
        if ( s!= null && s.contains("payment:")){
            credit.setPaymentMonth(Double.parseDouble(s.split(":")[1]));
        }
    }

    private void getTermAndSet(String s, Credit credit) {
        if ( s!= null && s.contains("term:")){
            credit.setCreditTerm(Integer.parseInt(s.split(":")[1]));
        }
    }

    private void getIdHolderAndSet(String s, Credit credit) {
        if ( s!= null && s.contains("idHolder:")){
            credit.setIdHolder(s.split(":")[1]);
        }
    }
}


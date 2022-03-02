package com.company.data;

import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.accountManagementDepartment.AccountMoney;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BDReadAccountMoney {
    private String CLIENT_MAPA = "clients.txt";
    private ArrayList<AccountMoney> accountList = new ArrayList<>();
    AccountMoney accountMoney;
    public  void readBD (BankOffice bankOffice, String filebd){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filebd))) {
            String currentLine = " ";
            while (null != (currentLine = bufferedReader.readLine())) {
                accountMoney = convertStringToClient(currentLine);
                accountList.add(accountMoney);

            }
            bankOffice.getBankCollections().getAccountList().removeAll(bankOffice.getBankCollections().getAccountList());
            bankOffice.getBankCollections().getAccountList().addAll(accountList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AccountMoney convertStringToClient ( String currentLine){
        String[] sp = currentLine.split(" ");
        AccountMoney accountMoney1 = new AccountMoney();
        for (String s : sp){
            getNameAndSet(s,accountMoney1);
            getNumberAndSet(s,accountMoney1);
            getMoneyinAndSet(s,accountMoney1);
          //  getDateAndSet(s,accountMoney1);
            getTermAndSet(s,accountMoney1);
            getPaymentAndSet(s,accountMoney1);
            getCashbackAndSet(s,accountMoney1);
            getPinAndSet(s,accountMoney1);
            getIdholderAndSet(s,accountMoney1);
        }
        return accountMoney1;
    }
    private void getPinAndSet(String s, AccountMoney ac) {
        if ( s!= null && s.contains("pin:")){
            ac.setPin(s.split(":")[1]);
        }
    }

    private void getIdholderAndSet(String s, AccountMoney ac) {
        if ( s!= null && s.contains("idHolder:")){
            ac.setIdHolder(s.split(":")[1]);
        }
    }

    private void getCashbackAndSet(String s, AccountMoney ac) {
        if ( s!= null && s.contains("cashBack:")){
            ac.setCashBack(Double.valueOf(s.split(":")[1]));
        }

    }

    private void getPaymentAndSet(String s, AccountMoney ac) {
        if ( s!= null && s.contains("payment:")){
            ac.setPayment(Integer.valueOf(s.split(":")[1]));
        }
    }

    private void getTermAndSet(String s, AccountMoney ac) {
        if ( s!= null && s.contains("term:")){
            ac.setCreditTerm(Integer.valueOf(s.split(":")[1]));
        }
    }



    private void getMoneyinAndSet(String s, AccountMoney ac) {
        if ( s!= null && s.contains("moneyIn:")){
            ac.setMoneyInAccount(Integer.valueOf(s.split(":")[1]));
        }
    }

    private void getNumberAndSet(String s, AccountMoney ac) {
        if ( s!= null && s.contains("number:")){
            ac.setAccountNumber(s.split(":")[1]);
        }
    }

    private void getNameAndSet(String s, AccountMoney ac) {
        if ( s!= null && s.contains("name:")){
            ac.setNameAccount(s.split(":")[1]);
        }
    }

}

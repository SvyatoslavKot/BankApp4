package com.company.data;

import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory.AccountMoney;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BDReadAccountMoney {
    private String nameAccount;
    private String accountNumber;
    private int moneyInAccount;
    // private DataFormat openingDate;
    private int creditTerm;
    private int payment;
    private double cashBack;
    private String idHolder;
    private String pin;

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
       // AccountMoney accountMoney1 = new AccountMoney();
        for (String s : sp){
            setNamei(s);
            setNumberi(s);
            setMoneyi(s);
          //  getDateAndSet(s,accountMoney1);
            setTermi(s);
            setPaymenti(s);
            setCashbacki(s);
            setPini(s);
            setIdHolderi(s);
        }
        return new AccountMoney.Builder().setNameAccount(nameAccount).setAccountNumber(accountNumber)
                .setMoneyInAccount(moneyInAccount).setCreditTerm(creditTerm).setPayment(payment).setCashBack(cashBack)
                .setPin(pin).setIdHolder(idHolder).build();
    }
    private void setPini(String s) {
        if ( s!= null && s.contains("pin:")){
            setPin(s.split(":")[1]);
        }
    }

    private void setIdHolderi(String s) {
        if ( s!= null && s.contains("idHolder:")){
            setIdHolder(s.split(":")[1]);
        }
    }

    private void setCashbacki(String s) {
        if ( s!= null && s.contains("cashBack:")){
            setCashBack(Double.valueOf(s.split(":")[1]));
        }

    }

    private void setPaymenti(String s) {
        if ( s!= null && s.contains("payment:")){
            setPayment(Integer.valueOf(s.split(":")[1]));
        }
    }

    private void setTermi(String s) {
        if ( s!= null && s.contains("term:")){
            setCreditTerm(Integer.valueOf(s.split(":")[1]));
        }
    }



    private void setMoneyi(String s) {
        if ( s!= null && s.contains("moneyIn:")){
            setMoneyInAccount(Integer.valueOf(s.split(":")[1]));
        }
    }

    private void setNumberi(String s) {
        if ( s!= null && s.contains("number:")){
            setAccountNumber(s.split(":")[1]);
        }
    }

    private void setNamei(String s) {
        if ( s!= null && s.contains("name:")){
            setNameAccount(s.split(":")[1]);
        }
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setMoneyInAccount(int moneyInAccount) {
        this.moneyInAccount = moneyInAccount;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }

    public void setIdHolder(String idHolder) {
        this.idHolder = idHolder;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}

package com.company.data;

import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.ProductBuilder;
import com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory.AccountMoney;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.currentThread;

public class DBReadAccountMoney{
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

    private static DBReadAccountMoney readAccountMoney;

    private DBReadAccountMoney() {
    }




    public static DBReadAccountMoney getInstance(){
        if(readAccountMoney == null){
            readAccountMoney = new DBReadAccountMoney();
        }return readAccountMoney;
    }


    public  void readBD (BankOffice bankOffice, String filebd){
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t = currentThread();
                System.out.println(t.getName()+ " - чтение списка счетов из txt");
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

        });
        thread2.start();
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
        return new ProductBuilder.Builder().setNameProduct(nameAccount).setNumber(accountNumber)
                .setMoneyInAccount(moneyInAccount).setTerm(creditTerm).setPayment(payment).setCashBack(cashBack)
                .setPin(pin).setClientId(idHolder).buildAccount();
    }
    private void setPini(String s) {
        if ( s!= null && s.contains("pin:")){
            this.pin = s.split(":")[1];
        }
    }
    private void setIdHolderi(String s) {
        if ( s!= null && s.contains("idHolder:")){
            this.idHolder = s.split(":")[1];
        }
    }
    private void setCashbacki(String s) {
        if ( s!= null && s.contains("cashBack:")){
            this.cashBack = Double.valueOf(s.split(":")[1]);
        }

    }
    private void setPaymenti(String s) {
        if ( s!= null && s.contains("payment:")){
            this.payment = Integer.valueOf(s.split(":")[1]);
        }
    }
    private void setTermi(String s) {
        if ( s!= null && s.contains("term:")){
            this.creditTerm = Integer.valueOf(s.split(":")[1]);
        }
    }
    private void setMoneyi(String s) {
        if ( s!= null && s.contains("moneyIn:")){
            this.moneyInAccount = Integer.valueOf(s.split(":")[1]);
        }
    }
    private void setNumberi(String s) {
        if ( s!= null && s.contains("number:")){
           this.accountNumber = s.split(":")[1];
        }
    }
    private void setNamei(String s) {
        if ( s!= null && s.contains("name:")){
            this.nameAccount = s.split(":")[1];
        }
    }
}

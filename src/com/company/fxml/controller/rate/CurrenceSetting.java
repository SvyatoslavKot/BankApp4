package com.company.fxml.controller.rate;

import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;
import com.company.data.currencyReader.Currence;
import com.company.data.currencyReader.CurrenceReader;
import com.company.fxml.controller.MainScene;
import javafx.scene.text.Text;

public class CurrenceSetting extends Thread {
    BankOffice bankOffice = MainFxml.getBankOffice();
    private static CurrenceSetting currenceSetting;
    private  CurrenceSetting(){
    }
    public  static  CurrenceSetting getInstance(){
        if (currenceSetting == null){
            currenceSetting = new CurrenceSetting();
        }return currenceSetting ;
    }
    private  boolean us;
    private  boolean ue;
    private  boolean cny;
    CurrenceReader currenceReader = new CurrenceReader();
    public void setVisbleRate ( Text b , Text n, Text s, String currenceName) {
        if (currenceName.equals("us")) {
            if (isUs()) {
                b.setText(bankOffice.getBankCollections().getCurrencyCBR().get("840").getValues());
                s.setText("0");
                b.setVisible(true);
                n.setVisible(true);
                s.setVisible(true);
            } else {
                b.setVisible(false);
                n.setVisible(false);
                s.setVisible(false);
            }
        } else if (currenceName.equals("eu")) {
            if (isUe()) {
                b.setText(bankOffice.getBankCollections().getCurrencyCBR().get("978").getValues());
                s.setText("0");
                b.setVisible(true);
                n.setVisible(true);
                s.setVisible(true);
            } else {
                b.setVisible(false);
                n.setVisible(false);
                s.setVisible(false);
            }
        } else if (currenceName.equals("cny")) {
            if (isCny()) {
                b.setText(bankOffice.getBankCollections().getCurrencyCBR().get("156").getValues());
                s.setText("0");
                b.setVisible(true);
                n.setVisible(true);
                s.setVisible(true);
            } else {
                b.setVisible(false);
                n.setVisible(false);
                s.setVisible(false);
            }
        }
    }
    public boolean isUs() {
        return us;
    }
    public void setUs(boolean us) {
        this.us = us;
    }
    public boolean isUe() {
        return ue;
    }
    public void setUe(boolean ue) {
        this.ue = ue;
    }
    public boolean isCny() {
        return cny;
    }
    public void setCny(boolean cny) {
        this.cny = cny;
    }
}

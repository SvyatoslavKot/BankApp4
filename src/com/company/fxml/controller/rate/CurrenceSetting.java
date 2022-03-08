package com.company.fxml.controller.rate;

import com.company.data.currencyReader.Currence;
import com.company.data.currencyReader.CurrenceReader;
import com.company.fxml.controller.MainScene;

public class CurrenceSetting extends Thread {
    private  boolean us;
    private  boolean ue;
    private  boolean cny;

    private Currence currence = new Currence();
    CurrenceReader currenceReader = new CurrenceReader();




    private CurrenceSetting() {
    }

    private static CurrenceSetting rateSetting;

    public static CurrenceSetting getInstance() {
        if (rateSetting ==null){
            rateSetting = new CurrenceSetting();
        }
        return rateSetting;
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

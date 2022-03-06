package com.company.fxml.controller.rate;

public class CurrenceSetting {
    private  boolean us;
    private  boolean ue;
    private  boolean cny;

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

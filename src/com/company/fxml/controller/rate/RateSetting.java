package com.company.fxml.controller.rate;

public class RateSetting {
    private  boolean us;
    private  boolean ue;
    private  boolean cny;

    private RateSetting() {
    }

    private static RateSetting rateSetting;

    public static RateSetting getInstance() {
        if (rateSetting ==null){
            rateSetting = new RateSetting();
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

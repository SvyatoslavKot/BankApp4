package com.company.data.currencyReader;

public class Currence {
    private static Currence currence;

    private Currence() {
    }

    public static Currence getInstance(){
        if (currence == null){
            currence = new Currence();
        } return currence;
    }

    String us;
    String eu;
    String cny;

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getEu() {
        return eu;
    }

    public void setEu(String eu) {
        this.eu = eu;
    }

    public String getCny() {
        return cny;
    }

    public void setCny(String cny) {
        this.cny = cny;
    }
}

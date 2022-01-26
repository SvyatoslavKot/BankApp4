package com.company.bankOffice.insuranceDepartment;

public class Insurance {
    private String nameInsurance;
    private String dateInsurance;
    private String timeInsurance;
    private int priceInsurance;

    public Insurance() {

    }

    public Insurance openInsuranceType1() {
        this.nameInsurance = "nameInsurance1";
        this.dateInsurance = "dateInsurance";
        this.timeInsurance = "timeInsurance";
        this.priceInsurance = 5000;
        return openInsuranceType1();
    }
    public void insuranceType2() {
        this.nameInsurance = "nameInsurance2";
        this.dateInsurance = "dateInsurance";
        this.timeInsurance = "timeInsurance";
        this.priceInsurance = 10000;
    }

    public void insuranceType3() {
        this.nameInsurance = "nameInsurance3";
        this.dateInsurance = "dateInsurance";
        this.timeInsurance = "timeInsurance";
        this.priceInsurance = 15000;
    }

    public String getNameInsurance() {
        return nameInsurance;
    }

    public String getDateInsurance() {
        return dateInsurance;
    }

    public String getTimeInsurance() {
        return timeInsurance;
    }

    public int getPriceInsurance() {
        return priceInsurance;
    }
}
package com.company.service.Parser;

public class CurElement {
    private String cod;
    private String Abr;
    private String unit;
    private String title;
    private String values;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getAbr() {
        return Abr;
    }

    public void setAbr(String abr) {
        Abr = abr;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "CurElement{" +
                "cod='" + cod + '\'' +
                ", Abr='" + Abr + '\'' +
                ", unit='" + unit + '\'' +
                ", title='" + title + '\'' +
                ", values='" + values + '\'' +
                '}';
    }
}

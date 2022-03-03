package com.company.data;

import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory.Insurance;
import com.company.bank.bankOffice.bankFactory.ProductBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class BDReadInsurance {
    private String nameInsurance;
    private int insuranceValue;
    private double price;
    private int term;
    private Date openDate;
    private String insuranceNumber;
    private String clientId;
    private String info;
    private ArrayList<Insurance> insuranceList = new ArrayList<>();
    Insurance insurance;

    public void readBD(BankOffice bankOffice, String filebd) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filebd))) {
            String currentLine = " ";
            while (null != (currentLine = bufferedReader.readLine())) {
                insurance = convertStringToInsurance(currentLine);
                insuranceList.add(insurance);
            }
            bankOffice.getBankCollections().getInsurensList().removeAll(bankOffice.getBankCollections().getInsurensList());
            bankOffice.getBankCollections().getInsurensList().addAll(insuranceList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Не удалось преобразовать строку в Integer");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Insurance convertStringToInsurance(String currentLine) {
        String[] sp = currentLine.split(" ");
        //Insurance insurance1 = new Insurance();
        for (String s : sp) {
            getNameAndSet(s);
            getNumberAndSet(s);
            getValueAndSet(s);
            getPriceAndSet(s);
            getTermAndSet(s);
            getIdHolderAndSet(s);
        }
        return new ProductBuilder.Builder().setNameProduct(nameInsurance).setNumber(insuranceNumber).setInsuranceValue(insuranceValue)
                .setInsirancePrice(price).setTerm(term).setClientId(clientId).build();
    }

    private void getNameAndSet(String s) {
        if (s != null && s.contains("name:")) {
            setNameInsurance(s.split(":")[1]);
        }
    }

    private void getNumberAndSet(String s) {
        if (s != null && s.contains("number:")) {
            setInsuranceNumber(s.split(":")[1]);
        }
    }

    private void getValueAndSet(String s) {
        if (s != null && s.contains("value:")) {
            setInsuranceValue(Integer.parseInt(s.split(":")[1]));
        }
    }

    private void getPriceAndSet(String s) {
        if ( s!= null && s.contains("price:")){
            setPrice(Double.parseDouble(s.split(":")[1]));
        }
    }

    private void getTermAndSet(String s) {
        if ( s!= null && s.contains("term:")){
            setTerm(Integer.parseInt(s.split(":")[1]));
        }
    }

    private void getIdHolderAndSet(String s) {
        if ( s!= null && s.contains("idHolder:")){
            setClientId(s.split(":")[1]);
        }
    }

    public void setNameInsurance(String nameInsurance) {
        this.nameInsurance = nameInsurance;
    }

    public void setInsuranceValue(int insuranceValue) {
        this.insuranceValue = insuranceValue;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

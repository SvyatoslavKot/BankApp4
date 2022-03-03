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
            this.nameInsurance = s.split(":")[1];
        }
    }
    private void getNumberAndSet(String s) {
        if (s != null && s.contains("number:")) {
            this.insuranceNumber = s.split(":")[1];
        }
    }
    private void getValueAndSet(String s) {
        if (s != null && s.contains("value:")) {
            this.insuranceValue = Integer.parseInt(s.split(":")[1]);
        }
    }
    private void getPriceAndSet(String s) {
        if ( s!= null && s.contains("price:")){
            this.price = Double.parseDouble(s.split(":")[1]);
        }
    }
    private void getTermAndSet(String s) {
        if ( s!= null && s.contains("term:")){
            this.term = Integer.parseInt(s.split(":")[1]);
        }
    }
    private void getIdHolderAndSet(String s) {
        if ( s!= null && s.contains("idHolder:")){
            this.clientId = s.split(":")[1];
        }
    }

}

package com.company.BD_Bank;

import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.insuranceDepartment.Insurance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BDReadInsurance {
    //private String CLIENT_MAPA = "insurances.txt";
    private ArrayList<Insurance> insuranceList = new ArrayList<>();
    Insurance insurance;

    public void readBD(BankOffice bankOffice, String filebd) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filebd))) {
            String currentLine = " ";
            while (null != (currentLine = bufferedReader.readLine())) {
                insurance = convertStringToInsurance(currentLine);
                insuranceList.add(insurance);
            }
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
        Insurance insurance1 = new Insurance();
        for (String s : sp) {
            getNameAndSet(s, insurance1);
            getNumberAndSet(s, insurance1);
            getValueAndSet(s, insurance1);
            getPriceAndSet(s, insurance1);
            getTermAndSet(s, insurance1);
            getIdHolderAndSet(s, insurance1);
        }
        return insurance1;
    }

    private void getNameAndSet(String s, Insurance insurance) {
        if (s != null && s.contains("name:")) {
            insurance.setNameInsurance(s.split(":")[1]);
        }
    }

    private void getNumberAndSet(String s, Insurance insurance) {
        if (s != null && s.contains("number:")) {
            insurance.setInsuranceNumber(s.split(":")[1]);
        }
    }

    private void getValueAndSet(String s, Insurance insurance) {
        if (s != null && s.contains("value:")) {
            insurance.setInsuranceValue(Integer.parseInt(s.split(":")[1]));
        }
    }

    private void getPriceAndSet(String s, Insurance insurance) {
        if ( s!= null && s.contains("price:")){
            insurance.setPrice(Double.parseDouble(s.split(":")[1]));
        }
    }

    private void getTermAndSet(String s, Insurance insurance) {
        if ( s!= null && s.contains("term:")){
            insurance.setTerm(Integer.parseInt(s.split(":")[1]));
        }
    }

    private void getIdHolderAndSet(String s, Insurance insurance) {
        if ( s!= null && s.contains("idHolder:")){
            insurance.setClientId(s.split(":")[1]);
        }
    }
}

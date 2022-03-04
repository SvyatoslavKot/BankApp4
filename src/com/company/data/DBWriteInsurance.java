package com.company.data;

import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory.Insurance;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DBWriteInsurance {
    private static DBWriteInsurance bdWriteInsurance;
    private DBWriteInsurance(){
    }

    public static DBWriteInsurance getInstance(){
        if (bdWriteInsurance == null) {
            bdWriteInsurance = new DBWriteInsurance();
        }
        return bdWriteInsurance;
    }

    public void writeInsurance (BankOffice bankOffice, String fileBD){
        try (FileWriter fw = new FileWriter(fileBD)){
            fw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Insurance> insurancesList = bankOffice.getBankCollections().getInsurensList();
        for (Insurance insurance:insurancesList){
            //insurance = ins;
            try (FileWriter fileWriter  =new FileWriter(fileBD, true)) {

                fileWriter.write("name:"+insurance.getNameInsurance()+" ");
                fileWriter.write("number:"+insurance.getInsuranceNumber()+" ");
                fileWriter.write("value:"+insurance.getInsuranceValue()+" ");
                //fileWriter.write("date:"+insurance.getOpeningDate()+" ");
                fileWriter.write("price:"+insurance.getPrice()+" ");
                fileWriter.write("term:"+insurance.getTerm()+" ");
                fileWriter.write("idHolder:"+insurance.getClientId()+" ");
                fileWriter.write("\n");

                fileWriter.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

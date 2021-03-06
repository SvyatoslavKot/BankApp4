package com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.ProductBuilder;

public class InsuranceProperty implements InsuranceCreater{
    @Override
    public Insurance create(Client client, BankOffice bankOffice, int insuranceValue, int term) {
        if (term == 1){
            double price = (insuranceValue / 1000 )* 0.2 ;
            return new ProductBuilder.Builder().setNameProduct("Имущества_1").setTerm(term).setInsuranceValue(insuranceValue)
                    .setInsirancePrice(price).setClientId(client.getId()).buildInsurance();
        }else if (term >1 && term <=3 ){
            double price= (insuranceValue / 1000) * 0.4;
            return new ProductBuilder.Builder().setNameProduct("Имущества_2").setTerm(term).setInsuranceValue(insuranceValue)
                    .setInsirancePrice(price).setClientId(client.getId()).buildInsurance();
        }else  if (term > 3 && term <= 6) {
            double price = (insuranceValue / 1000) * 0.6;
            return new ProductBuilder.Builder().setNameProduct("Имущества_3").setTerm(term).setInsuranceValue(insuranceValue)
                    .setInsirancePrice(price).setClientId(client.getId()).buildInsurance();
        }else  if (term > 6 && term <= 9) {
            double price = (insuranceValue / 1000) * 0.6;
            return new ProductBuilder.Builder().setNameProduct("Имущества_4").setTerm(term).setInsuranceValue(insuranceValue)
                    .setInsirancePrice(price).setClientId(client.getId()).buildInsurance();
        }else if (term > 9 && term <= 12) {
            double price = insuranceValue / 1000;
            return new ProductBuilder.Builder().setNameProduct("Имущества_5").setTerm(term).setInsuranceValue(insuranceValue)
                    .setInsirancePrice(price).setClientId(client.getId()).buildInsurance();
        }else {
            return  null;
        }
    }
}

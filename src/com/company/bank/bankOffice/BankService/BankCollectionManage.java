package com.company.bank.bankOffice.BankService;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.accountManagementDepartment.AccountMoney;
import com.company.bank.bankOffice.insuranceDepartment.Insurance;
import javafx.scene.control.TextField;

import java.util.*;

public class BankCollectionManage {

    public void sortInsuranseUpDown(BankOffice bankOffice){
        ArrayList<Insurance> insurances = bankOffice.getBankCollections().getInsurensList();
        insurances.sort(Comparator.comparing(Insurance::getPrice).reversed());
    }
    public void sortInsuranseDownUp(BankOffice bankOffice){
        ArrayList<Insurance> insurances = bankOffice.getBankCollections().getInsurensList();
        insurances.sort(Comparator.comparing(Insurance::getPrice));
    }
    public void viewInsuranceByClient(Client client, BankOffice bankOffice) {
        String id = client.getId();
        ArrayList<Insurance> insurances = bankOffice.getBankCollections().getInsurensList();
        for (Insurance insurance : insurances) {
            if (insurance.getClientId().equals(id))
                System.out.println("\nНазвание: " + insurance.getNameInsurance() +
                        "\nНомер счета: " + insurance.getInsuranceNumber() +
                        "\nсрок страхования: " + insurance.getTerm() + " мес." +
                        "\nдата открытия: " + insurance.getOpenDate() +
                        "\nстоимость стрхования: " + insurance.getPrice() +
                        "\nстраховая сумма: " + insurance.getInsuranceValue() +
                        "\n____________________________________________");
        }
    }

    public void viewAllInsurance(BankOffice bankOffice) {
        ArrayList<Insurance> insurances = bankOffice.getBankCollections().getInsurensList();
        for (Insurance insurance : insurances) {
            System.out.println(
                    insurance.getNameInsurance() + "\n" +
                            insurance.getInsuranceNumber() + "\n" +
                            insurance.getClientId());
        }
    }

    public void deleteInsuranceByAccontNumber(BankOffice bankOffice, String accNum) {
        ArrayList<Insurance> insurances = bankOffice.getBankCollections().getInsurensList();
        for (int i = 0 ; i < bankOffice.getBankCollections().getInsurensList().size(); i ++ ) {
            if (insurances.get(i).equals(accNum))
                insurances.remove(i);

        }
    }
    public  void deleteAllInsuranceByClient(BankOffice bankOffice, Client client){
        String id = client.getId();
        ArrayList<Insurance> insurances = bankOffice.getBankCollections().getInsurensList();
        for (int i = 0; i<insurances.size();i ++) {
            if (insurances.get(i).equals(id))
                insurances.remove(i);
        }
    }
    public  void viewAllClient(BankOffice bankOffice){
        HashMap<String,Client> client = bankOffice.getBankCollections().getClientHashMap();
        for (Map.Entry list: client.entrySet()){
            System.out.println(
                    "Id клиента: " + list.getValue()
            );
        }
    }
    public AccountMoney searchAccountFromNumber (BankOffice bankOffice, String number){
       ArrayList<AccountMoney> accounts = bankOffice.getBankCollections().getAccountList();
        for (AccountMoney acc : accounts){
            if (acc.getAccountNumber().equals(number)){
                System.out.println(acc.getAccountNumber());
                return acc;
            }
        }return null;
    }


}

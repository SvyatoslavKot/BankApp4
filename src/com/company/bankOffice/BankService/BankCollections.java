package com.company.bankOffice.BankService;

import com.company.Client;
import com.company.bankOffice.insuranceDepartment.InsuranceModel;
import com.company.bankOffice.insuranceDepartment.InsuranceOpen;

import java.util.ArrayList;
import java.util.HashMap;


public class BankCollections {
    public HashMap<String, Client> clientHashMap = new HashMap<>();
    private ArrayList<InsuranceModel> insurensList = new ArrayList<>();

    public void sourceInsurence (Client client){
        System.out.println(client.getName() + " у вас найдены страховки с номером : ");
        String id = client.getId();
        for (InsuranceModel insurance : insurensList){
            if (insurance.getClientId().equals(id))
                System.out.println(insurance.getInsuranceNumber());
        }
    }

    public HashMap<String, Client> getClientHashMap() {
        return clientHashMap;
    }
    public ArrayList<InsuranceModel> getInsurensList() {
        return insurensList;
    }
}

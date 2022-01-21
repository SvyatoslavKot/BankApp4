package com.company.bankOffice;



import java.util.HashMap;
import java.util.Map;

public class BankOffice {
    private String nameBank;

    public BankOffice(String nameBank) {
        this.nameBank = nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }
    public String getNameBank() {
        return nameBank;
    }

    HashMap<String,String> creditClientList = new HashMap<>();
    HashMap<String,String> clientBankList = new HashMap<>();
    public void viewClientList (){
        System.out.println("-----Список Клиентов-----");
        for (Map.Entry viewList: getCreditClientList().entrySet()){

            System.out.println(
                    "\nНомер паспорта: " + viewList.getKey() +
                            "\nИмя клиента: " + viewList.getValue());
        }

    }
    public void viewCreditClientList (){
        System.out.println("-----Список Оформленных кредитов-----");
        for (Map.Entry viewList: getCreditClientList().entrySet()){

            System.out.println(
                    "\nНомер кредитного счёта: " + viewList.getKey() +
                            "\nИмя клиента: " + viewList.getValue());
        }
    }

    public HashMap<String, String> getCreditClientList() {
        return creditClientList;
    }
    public HashMap<String, String> getClientBankList() {
        return clientBankList;
    }


}
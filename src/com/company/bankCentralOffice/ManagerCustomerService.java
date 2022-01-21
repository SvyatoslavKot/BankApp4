package com.company.bankCentralOffice;

import com.company.Client;
import com.company.bankOffice.Staff;

public class ManagerCustomerService extends Staff {
    public void writtenRequestToTheBank(Client client, String a){

        if (a.equals("Юредическое лицо")){
            System.out.println(client.getName() + " написал письменное обращение в Банк как юредическое лицо.");
        }else if (a.equals("Физическое лицо")){
            System.out.println(client.getName() + " написал письменное обращение в Банк как физическое лицо.");
        }else {
            System.out.println("Заявление не принято.");
        }
    }

    public void WriteComplaint(Client client, String a){
        if (a.equals("Юредическое лицо")){
            System.out.println(client.getName() + " написал жалобу в Банк как юредическое лицо.");
        }else if (a.equals("Физическое лицо")){
            System.out.println(client.getName() + " написал жалобу в Банк как физическое лицо.");
        }else {
            System.out.println("Заявление не принято.");
        }
    }
}
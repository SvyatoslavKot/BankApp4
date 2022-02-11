package com.company.bank.bankOffice;

import com.company.Client;
import com.company.bank.bankOffice.BankService.PaymentOperation;
import com.company.service.ClientService;

public class Kassa implements PaymentOperation {
    private double comission;
    ClientService clientService = new ClientService();

    public void payForComunalServis(Client client, int money){
        System.out.println("Оплатить комунальные услугу в кассе.");
        clientService.giveCash(money, client);
    }

    @Override
    public void paymentMobilPhoneCash(Client client, int money, String mobilPhone) {

    }

    @Override
    public void paymentMobilPhoneDebitCard(Client client, int money, String mobilPhone) {

    }


}

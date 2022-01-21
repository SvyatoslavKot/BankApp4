package com.company.bankOffice;

import com.company.Client;

public interface PaymentOperation {
    void payForComunalServis(Client client, int money);
    void paymentMobilPhoneCash(Client client, int money, String mobilPhone);
    void paymentMobilPhoneDebitCard( Client client, int money, String mobilPhone);
}
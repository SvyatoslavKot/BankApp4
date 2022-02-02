package com.company.bankOffice.creditDepartment;

import com.company.Client;
import com.company.service.CreditCalculationPayment;
import com.company.service.GenerateAccountNumber;
import com.company.bankOffice.BankOffice;
import com.company.service.ClientService;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CreditModel extends Credits{
    private String creditName;
    private String accountNumber;
    private int amount;
    private double ptc;
    private Date openingDate;
    private int creditTerm;
    private double paymentMonth;
    private String cardAccountNumber;
    private double cardPtc;
    private Date cardOpeningDate;
    private String cardCreditName;
    private int cardAmount;
    private String idHolder;

    GenerateAccountNumber generateAccountNumber = new GenerateAccountNumber();
    CreditCalculationPayment payment = new CreditCalculationPayment();
    ClientService clientService  = new ClientService();
    //Date date = new Date();

    public void openCredit(String creditName, Client client, int sum, BankOffice bankOffice, double ptc, int creditTerm ) {

        this.creditName = creditName;
        this.accountNumber = generateAccountNumber.accountNumber();
        this.amount = sum;
        this.ptc = ptc;
        this.openingDate = new Date();
        this.creditTerm = creditTerm;
        this.paymentMonth = payment.calc(this.amount,this.ptc,this.creditTerm);
        this.idHolder = client.getId();

        clientService.takeCash(amount,client);

        bankOffice.getCreditClientList().put(this.accountNumber,client.getName());
        bankOffice.getClientBankList().put(client.getPassport(),client.getName());
        client.getCreditListClient().put(this.accountNumber, this.creditName);
        client.getListOfAccounts().put(this.accountNumber, this.creditName);

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.println(client.getName() + " вам одобрен " + this.creditName +
                "\n________________ИНФОРМАЦИЯ__________________" +
                "\nномер счёта: " + accountNumber +
                "\nсрок кредита: " + this.creditTerm + " мес." +
                "\nдата открытия: " + dateFormat.format(openingDate) +
                "\nпроцентная ставка: " + this.ptc +
                "\nсумма займа: " + amount +
                "\nсумма ежемесячного платежа: " + String.format("%.2f", paymentMonth) + " руб." +
                "\n____________________________________________");
    }

    public void openCreditCard(String cardCreditName, Client client, int sum, BankOffice bankOffice, double ptc){
        this.cardAccountNumber = generateAccountNumber.accountNumber();
        this.cardOpeningDate = new Date();
        this.cardPtc = ptc;
        this.cardCreditName = cardCreditName;
        this.cardAmount = sum;

        bankOffice.getCreditClientList().put(this.cardAccountNumber,client.getName());
        bankOffice.getClientBankList().put(client.getPassport(),client.getName());
        client.getCreditListClient().put(this.cardAccountNumber, this.cardCreditName);
        client.getListOfAccounts().put(this.cardAccountNumber, this.cardCreditName);

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.println(client.getName() + " вам одобрен " + this.cardCreditName +
                "\n________________ИНФОРМАЦИЯ__________________" +
                "\nномер счёта: " + cardAccountNumber +
                "\nдата открытия: " + dateFormat.format(cardOpeningDate) +
                "\nпроцентная ставка: " + this.cardPtc +
                "\nсумма займа: " + cardAmount +
                "\n____________________________________________");
    }

}
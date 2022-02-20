package com.company.bank.bankOffice.creditDepartment;

import com.company.Client;
import com.company.service.CreditCalculationPayment;
import com.company.service.GenerateAccountNumber;
import com.company.bank.bankOffice.BankOffice;
import com.company.service.ClientService;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Credit extends CreditModel {
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

    public Credit() {
    }

    ClientService clientService  = new ClientService();
    //Date date = new Date();

    public Credit(String creditName, Client client, int sum, BankOffice bankOffice, double ptc, int creditTerm ) {

        this.creditName = creditName;
        this.accountNumber = generateAccountNumber.accountNumber();
        this.amount = sum;
        this.ptc = ptc;
        this.openingDate = new Date();
        this.creditTerm = creditTerm;
        this.paymentMonth = payment.calc(this.amount,this.ptc,this.creditTerm);
        this.idHolder = client.getId();

        //clientService.takeCash(amount,client);

        //bankOffice.getBankCollections().getCreditList().add(this);

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

        bankOffice.getBankCollections().getCreditList().add(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.println(client.getName() + " вам одобрен " + this.cardCreditName +
                "\n________________ИНФОРМАЦИЯ__________________" +
                "\nномер счёта: " + cardAccountNumber +
                "\nдата открытия: " + dateFormat.format(cardOpeningDate) +
                "\nпроцентная ставка: " + this.cardPtc +
                "\nсумма займа: " + cardAmount +
                "\n____________________________________________");
    }

    public String getCreditName() {
        return creditName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public double getPtc() {
        return ptc;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public int getCreditTerm() {
        return creditTerm;
    }

    public double getPaymentMonth() {
        return paymentMonth;
    }

    public String getIdHolder() {
        return idHolder;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPtc(double ptc) {
        this.ptc = ptc;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public void setPaymentMonth(double paymentMonth) {
        this.paymentMonth = paymentMonth;
    }

    public void setIdHolder(String idHolder) {
        this.idHolder = idHolder;
    }
}
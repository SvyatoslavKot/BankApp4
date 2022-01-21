package com.company.bankOffice.creditDepartment;

import com.company.Client;
import com.company.service.CreditCalculationPayment;
import com.company.service.GenerateAccountNumber;
import com.company.bankOffice.BankOffice;
import com.company.service.ClientService;


public class CreditModel extends Credits{
    private String creditName;
    private String accountNumber;
    private int amount;
    private double ptc;
    private String openingDate;
    private int creditTerm;
    private double paymentMonth;

    GenerateAccountNumber generateAccountNumber = new GenerateAccountNumber();
    CreditCalculationPayment payment = new CreditCalculationPayment();
    ClientService clientService  = new ClientService();

    public void openCredit(String creditName, Client client, int sum, BankOffice bankOffice, double ptc, int creditTerm ) {

        this.creditName = creditName;
        this.accountNumber = generateAccountNumber.accountNumber();
        this.amount = sum;
        this.ptc = ptc;
        this.openingDate = openingDate;
        this.creditTerm = creditTerm;
        this.paymentMonth = payment.calc(this.amount,this.ptc,this.creditTerm);

        clientService.takeCash(amount,client);

        bankOffice.getCreditClientList().put(this.accountNumber,client.getName());
        client.getCreditListClient().put(this.accountNumber, this.creditName);

        System.out.println(client.getName() + " вам одобрен " + this.creditName +
                "\n________________ИНФОРМАЦИЯ__________________" +
                "\nномер счёта: " + accountNumber +
                "\nсрок кредита: " + this.creditTerm + " мес." +
                "\nдата открытия: " + openingDate +
                "\nпроцентная ставка: " + this.ptc +
                "\nсумма задолности: " + amount +
                "\nсумма ежемесячного платежа: " + String.format("%.2f", paymentMonth) + " руб." +
                "\n____________________________________________");
    }
}
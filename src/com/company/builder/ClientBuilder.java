package com.company.builder;

import com.company.Client;
import com.company.bankCentralOffice.BankCentralOffice;
import com.company.bankOffice.Atm;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.SelfTerminal;
import com.company.mobilBank.*;
import com.company.mobilBank.chatBot.ChatBot;
import com.company.mobilBank.chatBot.MobilBankChatBot;

public class ClientBuilder {
    private final SelfTerminal selfServiceTerminal = new SelfTerminal();
    private final Atm atm = new Atm();
    private final MobilBankPayment mobilBankPayment = new MobilBankPayment();
    private final MobilBankCredit mobilBankCredit = new MobilBankCredit();
    private final MobilBankDebitAccount mobilBankDebitAccount = new MobilBankDebitAccount();
    private final MobilBankInsurance mobilBankInsurance = new MobilBankInsurance();
    private final com.company.mobilBank.chatBot.ChatBot ChatBot = new ChatBot();

    public SelfTerminal buildSelfServiceTerminal(BankOffice bankOffice, Client client) {
        selfServiceTerminal.setBankBuilder(bankOffice.getBankOfficeBuilder());
        bankOffice.getClientBankList().put(client.getPassport(),client.getName() + " " + client.getLastName());
        System.out.println(client.getName() + " подошел к терминалу самообслуживания в Банке "+ bankOffice.getNameBank() );
        return selfServiceTerminal;
    }
    public SelfTerminal buildSelfServiceTerminalCentralOffice(BankCentralOffice bankCentralOffice, Client client) {
        selfServiceTerminal.setBankBuilder(bankCentralOffice.getBankCentralOfficeBuilder());
        bankCentralOffice.getClientBankListCentral().put(client.getPassport(),client.getName() + " " + client.getLastName());
        System.out.println(client.getName() + " подошел к терминалу самообслуживания в Банке "+ bankCentralOffice.getNameBank() );
        return selfServiceTerminal;
    }


    public Atm buildAtm(BankOffice bankOffice, Client client) {
        System.out.println(client.getName() + " подошел к банкомату самообслуживания в Банке "+ bankOffice.getNameBank() );
        return atm;
    }

    public MobilBankPayment buildMobilBankPayment(MobilBank mobilBank, Client client) {
        System.out.println(client.getName() + " перешел в раздел 'платежи'  в " + mobilBank.getNameBank());

        return mobilBankPayment;
    }

    public MobilBankCredit buildMobilBankCredit(MobilBank mobilBank, Client client) {
        System.out.println(client.getName() + " перешел в раздел 'кредит' в " + mobilBank.getNameBank());
        return mobilBankCredit;
    }

    public MobilBankDebitAccount buildMobilBankDebitAccount(MobilBank mobilBank, Client client) {
        System.out.println(client.getName() + " перешел в раздел 'офоромление счёта' в " + mobilBank.getNameBank());
        return mobilBankDebitAccount;
    }

    public MobilBankInsurance buildMobilBankInsurance(MobilBank mobilBank, Client client) {
        System.out.println(client.getName() + " перешел в раздел 'страхование'в " + mobilBank.getNameBank());
        return mobilBankInsurance;
    }

    public void buildMobilBankChatBot(MobilBank mobilBank, Client client) {
        System.out.println(client.getName() + " открыл чат с чатБотомв " + mobilBank.getNameBank());
        MobilBankChatBot chatBot = new MobilBankChatBot(client);
    }
}

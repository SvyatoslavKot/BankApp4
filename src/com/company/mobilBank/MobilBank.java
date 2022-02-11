package com.company.mobilBank;


import com.company.Client;
import com.company.bankOffice.BankOffice;
import com.company.mobilBank.chatBot.MobilBankChatBot;

import javax.swing.*;

public class MobilBank {
    private String nameBank;
    MobilBankPayment mobilBankPayment;
    MobilBankCredit mobilBankCredit;
    MobilBankDebitAccount mobilBankDebitAccount;
    MobilBankInsurance mobilBankInsurance;

    public MobilBank(BankOffice bankOffice) {
        this.nameBank = bankOffice.getNameBank()+"Mobile";
        this.mobilBankPayment = new MobilBankPayment();
        this.mobilBankCredit = new MobilBankCredit();
        this.mobilBankDebitAccount = new MobilBankDebitAccount();
        this.mobilBankInsurance = new MobilBankInsurance();
    }
    public MobilBankChatBot openMobilBankChatBot() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MobilBankChatBot chatBot = new MobilBankChatBot();
            }
        });
        return null;
    }

    public String getNameBank() {
        return nameBank;
    }
}

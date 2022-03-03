package com.company.bank.bankOffice.bankFactory.creditDepartment.chatBotService;


public class CreditAccountBot {
    CreditBot creditBot = new CreditBot() ;
    private int sum ;
    private  int term;
    private String creditType;

    public String openCredit(){
        if (creditType.equals("1"))
            return  openConsumer();
        else if (creditType.equals("2"))
            return openAvto();
        else if (creditType.equals("3"))
            return openIppotec();
        else if (creditType.equals("4"))
            return openCreditCard();
        else
            return openCreditCard();
    }
    private String openConsumer(){
        if (sum < 50000){
        return  " мы можем предложить вам кредитную карту.";
        //credit.openCreditCard("Кредитная карта", client, sum, bankOffice, 18.9);
    }else if (sum > 50000 && sum <= 100000 ){
            return creditBot.openCreditChat("Потребительский 1",  sum,  17.9, 12);
    }else if (sum > 100000 && sum <= 200000 ){
            return creditBot.openCreditChat("Потребительский 2",  sum,  15.9, 24);
    }else if (sum > 200000 && sum <= 500000 ){
            return creditBot.openCreditChat("Потребительский 3",  sum,  16.9, 24);
    }else if (sum > 500000 && sum <= 1000000 ){
            return creditBot.openCreditChat("Потребительский 4",  sum,  14.9, 36);
    }else if (sum > 1000000 && sum <= 2000000 ){
            return creditBot.openCreditChat("Потребительский 5",  sum,  12.9, 60);
    }else {
        return "Для вас нет подходящих предложение потребительского кредита.";
    }
}

    private String openAvto(){
        if (sum < 100000){
            return " мы можем предложить вам кредитную карту.";
            //credit.openCreditCard("Кредитная карта", client, sum1, bankOffice, 18.9);
        }else if (sum > 100000 && sum <= 300000 ){
            return creditBot.openCreditChat("Авто 300",  sum,  17.9, 24);
        }else if (sum > 300000 && sum <= 500000 ){
            return creditBot.openCreditChat("Авто 300",  sum,  15.9, 36);
        }else if (sum > 500000 && sum <= 1000000 ){
            return creditBot.openCreditChat("Авто 300",  sum,  12.9, 36);
        }else if (sum > 1000000 && sum <= 2000000 ){
            return creditBot.openCreditChat("Авто 300",  sum,  9.9, 60);
        }else if (sum > 2000000 && sum <= 3000000 ){
            return creditBot.openCreditChat("Авто 300",  sum,  7.9, 60);
        }else {
            return "Для вас нет подходящих предложение потребительского кредита.";
        }
    }

    private String openIppotec (){
        if (sum < 1000000){
            return " мы можем предложить вам потребительский кредит.";
        }else if (sum > 1000000 && sum <= 1300000 ){
            return creditBot.openCreditChat("Иппотека 1",  sum,  15.9, 120);
        }else if (sum > 1300000 && sum <= 1500000 ){
            return creditBot.openCreditChat("Иппотека 1",  sum,  12.9, 240);
        }else if (sum > 1500000 && sum <= 5000000 ){
            return creditBot.openCreditChat("Иппотека 1",  sum,  9.9, 360);
        }else if (sum > 5000000 && sum <= 10000000 ){
            return creditBot.openCreditChat("Иппотека 1",  sum,  6.9, 480);
        }else if (sum > 10000000 && sum <= 30000000 ){
            return creditBot.openCreditChat("Иппотека 1",  sum,  4.9, 600);
        }else {
            return  "Для вас нет подходящих предложений";
        }
    }
    private String openCreditCard(){
        if ( sum <= 100000 ){
            return creditBot.openCreditChat("Кредитная Карта",  sum,  25.9, 12);
        }else if (sum > 100000 && sum <= 200000 ){
            return creditBot.openCreditChat("Кредитная карта 2",  sum,  17.9, 24);
        }else {
            return "Для вас нет подходящих предложение потребительского кредита.";
        }
    }
    public void setTerm(int term) {
        this.term = term;
    }
    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
}

package com.company.mobilBank.chatBot;

import com.company.bankOffice.creditDepartment.chatBotService.CreditAccountBot;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class SimpleBot {

    CreditAccountBot credit;

    final Map<String,String> PATTERNS_FOR_ANALYSIS = new HashMap<>() {
        {
            put("привет","hello");
            put("здорова","hello");
            put("зравствуйте","hello");
            put("приветики","hello");

            put("как\\s.*дела","howareyou");
            put("как\\s.*оно","howareyou");
            put("как\\s.*ты","howareyou");

            put("кто\\s.*ты","who");

            put("как\\s.*зовут","name");
            put("как\\s.*имя","name");

            put("который\\s.*час","whattime");

            put("\\s.*доллара","dollar");

            put("\\s.*евро","evro");

            put("\\s.*кредит","credit");
            put("оформить\\s.*кредит","credit");
            put("открыть\\s.*кредит","credit");
            put("взять\\s.*кредит","credit");

            put("creditsum","creditsum");

            put("creditTerm","creditTerm");

            put("credittype","credittype");



        }};
    final Map<String,String> ANSWERS_BY_PATTERNS  = new HashMap<>(){{
        put("hello", "Здравствуйте .");
        put("howareyou", "У меня все хорошо, спасибо.");
        put("who", "Я бот консультант");
        put("name", "Зовите меня Борис");

    }};
    public Map<String, String> getPATTERNS_FOR_ANALYSIS() {
        return PATTERNS_FOR_ANALYSIS;
    }
    public Map<String, String> getANSWERS_BY_PATTERNS() {
        return ANSWERS_BY_PATTERNS;
    }
    public Pattern getPattern() {
        return pattern;
    }
    Pattern pattern;
    Random random;
    Date date;
    public SimpleBot(){
        random  =new Random();
        date =new Date();


    }
}
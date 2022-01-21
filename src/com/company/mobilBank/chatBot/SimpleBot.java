package com.company.mobilBank.chatBot;

import com.company.Client;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class SimpleBot {

    final Map<String,String> PATTERNS_FOR_ANALYSIS = new HashMap<>() {
        {
            put("привет","hello");
            put("как\\s.*дела","howareyou");
            put("кто\\s.*ты","who");
            put("как\\s.*зовут","name");
            put("который\\s.*час","whattime");
        }};
    final Map<String,String> ANSWERS_BY_PATTERNS  = new HashMap<>(){{
        put("hello", "Здравствуйте.");
        put("howareyou", "У меня все хорошо, спасибо.");
        put("who", "Я бот консультант");
        put("name", "Зовите меня Борис");

    }};
    Client clientThis;
    Pattern pattern;
    Random random;
    Date date;

    public SimpleBot(Client client){
        random  =new Random();
        date =new Date();
        clientThis = client;

    }

    public  String sayInReturn(String messsage){
        String message =
                String.join(" ", messsage.toLowerCase().split("[ {,|.}?]+"));
        for (Map.Entry<String,String>o : PATTERNS_FOR_ANALYSIS.entrySet()){
            pattern = Pattern.compile(o.getKey());
            if(pattern.matcher(message).find())
                if(o.getValue().equals("whattime"))return date.toString();
                else
                    return ANSWERS_BY_PATTERNS.get(o.getValue());
        }return "say";
    }


}
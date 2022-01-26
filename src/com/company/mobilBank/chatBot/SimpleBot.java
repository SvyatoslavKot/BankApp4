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

        }};
    final Map<String,String> ANSWERS_BY_PATTERNS  = new HashMap<>(){{
        put("hello", "Здравствуйте .");
        put("howareyou", "У меня все хорошо, спасибо.");
        put("who", "Я бот консультант");
        put("name", "Зовите меня Борис");

    }};

    Pattern pattern;
    Random random;
    Date date;

    public SimpleBot(){
        random  =new Random();
        date =new Date();


    }

    public  String sayInReturn(String messsage){
        String message =
                String.join(" ", messsage.toLowerCase().split("[ {,|.}?]+"));
        for (Map.Entry<String,String>o : PATTERNS_FOR_ANALYSIS.entrySet()){
            pattern = Pattern.compile(o.getKey());
            if(pattern.matcher(message).find())
              if(o.getValue().equals("whattime"))return date.toString();
                else return ANSWERS_BY_PATTERNS.get(o.getValue());
        }return "say";
    }


}
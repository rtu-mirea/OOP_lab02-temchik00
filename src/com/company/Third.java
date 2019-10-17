package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Third {
    String text;
    Third(){
        this.text = "";
    }
    Third(String text){
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void checkNum(){
        if(text == ""){
            System.out.println("Инициализация не произведена"); return;
        }
        Pattern pattern = Pattern.compile("[01]\\d:[0-5]\\d|2[0-3]:[0-5]\\d");
        if(pattern.matcher(text).matches())
            System.out.println("Строка является правильным представлением времени");
        else
            System.out.println("Строка не является правильным представлением времени");
    }

    public void delNum(){
        if(text == ""){
            System.out.println("Инициализация не произведена"); return;
        }
        text = text.replaceAll("0[01]:[0-5]\\d\\s?|02:00\\s?", "");
        if(text.length() != 0 && text.charAt(text.length()-1) == ' ')
            text = text.substring(0, text.length()-1);
        System.out.println("Строка без времени от 00:00 до 02:00 - " + text);
    }
}

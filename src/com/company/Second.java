package com.company;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Second {
    StringBuilder text;
    HashSet<String> keys;
    Second(){
        this.text = new StringBuilder();
        this.keys = new HashSet<String>();
    }
    Second(StringBuilder text, HashSet<String> keys){
        this.text = text;
        this.keys = keys;
    }

    public void setKeys(HashSet<String> keys) {
        this.keys = keys;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }

    public void identificator(){
        if(text.length() == 0){
            System.out.println("Инициализация не произведена"); return;
        }
        if(keys.size() == 0){
            System.out.println("Инициализация не произведена"); return;
        }
        StringBuilder ans = new StringBuilder();
        int pos = text.indexOf("=");
        while(pos != -1){
            int spacePos = pos - 2;
            while(spacePos >= 0 && text.charAt(spacePos) != ' ')
                spacePos--;
            if(!keys.contains(text.substring(spacePos+1, pos-1)))
                ans.append(text.substring(spacePos+1, pos-1) + " ");
            pos = text.indexOf("=", pos+1);
        }
        ans.deleteCharAt(ans.length()-1);
        System.out.print("Идентификаторы: ");
        System.out.println(ans);
    }

    public void delIndent(){
        if(text.length() == 0){
            System.out.println("Инициализация не произведена"); return;
        }
        if(keys.size() == 0){
            System.out.println("Инициализация не произведена"); return;
        }
        StringBuilder ans = new StringBuilder();
        int pos = text.indexOf(" ");
        while(pos != -1){
            int spacePos = pos - 1;
            while(spacePos >= 0 && text.charAt(spacePos) != ' ')
                spacePos--;
            String word = text.substring(spacePos+1, pos);
            if(!keys.contains(word))
                ans.append(text.substring(spacePos+1, pos) + " ");
            pos = text.indexOf(" ", pos+1);
        }
        if (ans.length() > 0)
            ans.deleteCharAt(ans.length()-1);
        text = ans;
        System.out.print("Текст без идентификаторов: ");
        System.out.println(text);
    }
}

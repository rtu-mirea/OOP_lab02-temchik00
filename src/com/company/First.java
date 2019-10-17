package com.company;

import java.util.*;

public class First {
    String text;
    HashSet<String> keys;
    HashSet<String> types;
    HashSet<String> typeCreator;
    HashSet<String> userTypes;
    LinkedHashSet<String> words= new LinkedHashSet<String>();
    LinkedHashMap<String, Integer> count = new LinkedHashMap<String, Integer>();
    private final int shift = 'A' - 'a';
    First(){
        this.text = "";
        this.keys = new HashSet<String>();
        types = new HashSet<String>();
        typeCreator = new HashSet<String>();
        userTypes = new HashSet<String>();
        types.add("float");
        types.add("int");
        types.add("double");
        types.add("char");
        types.add("bool");
        typeCreator.add("struct");
    }
    First(String text, HashSet<String> keys){
        this.text = text;
        this.keys = keys;
        types = new HashSet<String>();
        typeCreator = new HashSet<String>();
        userTypes = new HashSet<String>();
        types.add("float");
        types.add("int");
        types.add("double");
        types.add("char");
        types.add("bool");
        typeCreator.add("struct");
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setKeys(HashSet<String> keys) {
        this.keys = keys;
    }

    public void showEntrys(){
        if(text == ""){
            System.out.println("Инициализация не произведена"); return;
        }
        if(keys.size() == 0){
            System.out.println("Инициализация не произведена"); return;
        }
        words.clear();
        for(String word:text.split("[ \n]")){
           if(keys.contains(word))
               words.add(word);
        }
        Iterator<String> it = words.iterator();
        System.out.print("Ключевые слова, встреченные в тексте:");
        while (it.hasNext()){
            System.out.print(" " + it.next());
        }
        System.out.println();
    }

    public void toUpper(){
        if(text == ""){
            System.out.println("Инициализация не произведена"); return;
        }
        if(keys.size() == 0){
            System.out.println("Инициализация не произведена"); return;
        }
        if(words.size() == 0){
            System.out.println("Массив не сформирован"); return;
        }
        ArrayList<String> tmp = new ArrayList<String>(0);
        Iterator<String> it = words.iterator();
        System.out.print("Ключевые слова, встреченные в тексте с заглавной буквы:");
        while (it.hasNext()){
            String word = it.next();
            word = (char)(word.charAt(0)+shift) + word.substring(1);
            System.out.print(" " + word);
            tmp.add(word);
        }
        words.clear();
        words.addAll(tmp);
        System.out.println();
    }

    public void countEntrys(){
        count.clear();
        if(text == ""){
            System.out.println("Инициализация не произведена"); return;
        }
        if(keys.size() == 0){
            System.out.println("Инициализация не произведена"); return;
        }
        words.clear();
        for(String word:text.split("[ \n]")){
            if(keys.contains(word)){
                if(count.containsKey(word))
                    count.put(word, count.get(word)+1);
                else
                    count.put(word, 1);
            }
        }
        List<String> keysIn = new ArrayList<String>(count.keySet());
        System.out.print("Ключевые слова, встреченные в тексте и количество их вхождений:");
        for(String key: keysIn)
            System.out.print(" " + key + " - " + count.get(key) + ",");
        System.out.println();
    }

    public void getIdentificators(){
        userTypes.clear();
        String[] arr = text.split("[ \n]");
        String ans = "";
        for(int i = 0; i < arr.length-1; i++){
            if(types.contains(arr[i]))
                ans += arr[i+1].replaceAll(";", "") + " ";
            else
                if(typeCreator.contains(arr[i])){
                    userTypes.add(arr[i+1]);
                    ans += arr[i+1].replaceAll(";", "") + " ";
                    i++;
                }
                else{
                    if(userTypes.contains(arr[i]))
                        ans += arr[i+1].replaceAll(";", "") + " ";
                }
        }
        System.out.print("Пользовательские идентификаторы: ");
        System.out.println(ans);
        text = ans;
    }
}

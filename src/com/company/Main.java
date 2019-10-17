package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int comm = -1;
        Scanner in = new Scanner(System.in);
        outputMenu();
        First first = new First();
        Second second = new Second();
        Third third = new Third();
        while(comm != 0){
            System.out.print("Введите команду: ");
            comm = in.nextInt();
            switch (comm){
                case 1:
                    outputMenu();
                    break;
                case 2:
                    String line = in.nextLine();
                    HashSet<String> keys = new HashSet<String>();
                    for(String key: line.split(" "))
                        keys.add(key);
                    first.setKeys(keys);
                    second.setKeys(keys);
                    break;
                case 3:
                    System.out.print("Введите текст: ");
                    first.setText(in.nextLine());
                    break;
                case 4:
                    first.showEntrys();
                    break;
                case 5:
                    first.toUpper();
                    break;
                case 6:
                    first.countEntrys();
                    break;
                case 7:
                    first.getIdentificators();
                    break;
                case 8:
                    System.out.print("Введите текст: ");
                    second.setText(new StringBuilder(in.nextLine()));
                    break;
                case 9:
                    second.identificator();
                    break;
                case 10:
                    second.delIndent();
                    break;
                case 11:
                    // Нэма
                    break;
                case 12:
                    System.out.print("Введите текст: ");
                    third.setText(in.nextLine());
                    third.checkNum();
                    break;
                case 13:
                    System.out.print("Введите текст: ");
                    third.setText(in.nextLine());
                    third.delNum();
                    break;
                case 0:
                    System.out.println("Завершение программы...");
                    break;
                default:
                    System.out.println("Введена неверная команда, повторите ввод;");
                    break;
            }
        }
    }

    public static void outputMenu(){
        System.out.println("1 - Вывести меню повторно,");
        System.out.println("2 - Ввести ключевые слова для первого и второго заданий,");
        System.out.println("3 - Ввести текст для первого задания,");
        System.out.println("4 - Сформировать строку из ключевых слов языка, которые используются в тексте,");
        System.out.println("5 - Первые строчные символы в словах сформированного массива заменить прописными,");
        System.out.println("6 - Сформировать массив, который хранит количество вхождений каждого ключевого слова в код программы,");
        System.out.println("7 - Сформировать строку из пользовательских идентификаторов,");
        System.out.println("8 - Ввести текст для второго задания,");
        System.out.println("9 - Сформировать строку из пользовательских идентификаторов левой части оператора присваивания,");
        System.out.println("10 - Преобразовать строку: оставить только ключевые слова языка, которые используются в тексте,");
        System.out.println("11 - Вставить новое ключевое слово, которого нет в строке, перед первым словом,");
        System.out.println("12 - Определить, является ли переданная строка корректным\n" +
                "временем вида '12:59', '23:41', '00:12', '00:00', '09:15',");
        System.out.println("13 - Удаление из текста всех значений времени из промежутка 00:00 до 02:00,");
        System.out.println("0 - Выход");
    }
}

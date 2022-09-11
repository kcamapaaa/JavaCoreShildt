package main.java.com.Vladislav.javacore.chapter29;

/*
Применить метод map() для создания нового
потока данных, содержащего только избранные
элементы из исходного потока
 */

import java.util.ArrayList;
import java.util.stream.Stream;

class NamePhoneEmail {
    String name;
    String phoneNum;
    String email;

    public NamePhoneEmail(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }
}

class NamePhone {
    String name;
    String phoneNum;

    public NamePhone(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }
}

public class StreamDemo5 {
    public static void main(String[] args) {

        //Список имен, номеров телефонов и
        //адресов электронной почты
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();

        myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@gmail.com"));
        myList.add(new NamePhoneEmail("James", "555-4444", "James@gmail.com"));
        myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@gmail.com"));

        System.out.println("Исходные данные списка myList: ");
        myList.stream().forEach((a) -> System.out.println(a.name + " " + a.phoneNum + " " + a.email));
        System.out.println();

        //отобразить на новый поток данных
        //только имена и номер телефонов

        Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phoneNum));
        System.out.println("Список имен и номеров телефонов: ");
        nameAndPhone.forEach(a -> System.out.println(a.name + " " + a.phoneNum));



























    }
}

package main.java.com.Vladislav.javacore.chapter21;

import java.io.Console;

public class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console con;

        //получить ссылку на консоль
        con = System.console();

        //выйти из программы, если консоль недоступна
        if(con == null) return;

        //прочесть строку и вывести ее
        str = con.readLine("Введите строку: ");
        con.printf("Введенная вами строка: %s\n", str);
    }
}

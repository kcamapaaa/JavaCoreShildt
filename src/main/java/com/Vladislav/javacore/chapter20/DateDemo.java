package main.java.com.Vladislav.javacore.chapter20;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        //вывести дату и время методом toString()
        System.out.println(date);


        //вывести количество милисекунд, прошедших с 1 января 1970 года по Гринвичу
        long msec = date.getTime();
        System.out.println("Milliseconds from 1 jan 1970 = " + msec);
    }
}

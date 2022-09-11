package main.java.com.Vladislav.javacore.chapter20;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarDemo {
    public static void main(String[] args) {
        String[] months = {"Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug", "Sep",
                "Oct", "Nov", "Dec"};
        int year;

        //создать григорианский календарь, инициализируемый
        //текущими датой и временем с учетом региональных
        //настроек и часового пояса по умолчанию

        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        System.out.println("Date: " + months[gregorianCalendar.get(Calendar.MONTH)] + " " + gregorianCalendar.get(Calendar.DATE) + " " + (year = gregorianCalendar.get(Calendar.YEAR)));
        System.out.println();
        System.out.println("Time: " + gregorianCalendar.get(Calendar.HOUR) + ":" + gregorianCalendar.get(Calendar.MINUTE) + ":" + gregorianCalendar.get(Calendar.SECOND));

        //проверить, является ли текущий год високосным
        if(gregorianCalendar.isLeapYear(2024)) {
            System.out.println("This is a Leap year");
        } else {
            System.out.println("This is not a Leap year");
        }
    }
}

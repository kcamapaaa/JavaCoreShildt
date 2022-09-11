package main.java.com.Vladislav.javacore.chapter20;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        String[] months = {"Jan", "Feb", "Mar", "Apr",
                        "May", "Jun", "Jul", "Aug", "Sep",
                        "Oct", "Nov", "Dec"};

        //создать календарь, инициализируемый
        //текущими датой и временем с учетом региональных
        //настроек и часового пояса по умолчанию

        Calendar calendar = Calendar.getInstance();

        //вывесть текущую дату и время
        System.out.println("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println("Time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
        System.out.println();

        //установить дату и время и вывести их
        calendar.set(Calendar.HOUR, 10);
        calendar.set(Calendar.MINUTE, 29);
        calendar.set(Calendar.SECOND, 22);

        System.out.println("Changed time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
    }
}

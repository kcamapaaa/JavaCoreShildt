package main.java.com.Vladislav.javacore.chapter29;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo9 {
    public static void main(String[] args) {

        //создать список символьных строк
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Альфа");
        myList.add("Бета");
        myList.add("Гамма");
        myList.add("Дельта");
        myList.add("Кси");
        myList.add("Омега");

        //получить поток данных для списочного массива
        Stream<String> myStream = myList.stream();

        //получить итератор для потока данных
        Spliterator<String> spliterator = myStream.spliterator();

        //перебрать элементы в потоке данных
        while(spliterator.tryAdvance(System.out::println));
    }
}

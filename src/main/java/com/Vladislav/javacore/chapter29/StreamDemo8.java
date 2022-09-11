package main.java.com.Vladislav.javacore.chapter29;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo8 {
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
        Iterator<String> iterator = myStream.iterator();

        //перебрать элементы в потоке данных
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

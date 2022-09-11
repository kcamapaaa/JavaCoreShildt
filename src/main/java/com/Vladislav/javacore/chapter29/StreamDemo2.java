package main.java.com.Vladislav.javacore.chapter29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class StreamDemo2 {
    public static void main(String[] args) {

        //создать список объектов типа Integer
        ArrayList<Integer> myList = new ArrayList<>();

        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        /*
        Два способа получения результата перемножения
        целочисленных элементов списка myList с помощью
        метода reduce()
         */

        Optional<Integer> productObj = myList.stream().reduce((a, b) -> a * b);
        productObj.ifPresent(n -> System.out.println("Произведение в виде объекта типа Optional: " + n));

        int product = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("произведение в виде значения типа int: " + product);

        //произведение только четных целочисленных значений

        int evenProduct = myList.stream().reduce(1, (a, b) -> {
            if(b % 2 == 0) return a * b; else return a;
        });
    }
}

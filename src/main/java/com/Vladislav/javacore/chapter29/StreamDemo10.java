package main.java.com.Vladislav.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo10 {
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

        //а теперь разделить первый итератор
        Spliterator<String> splitItr2 = spliterator.trySplit();

        //использовать сначала итератор splitItr2,
        //если нельзя разделить итератор splitItr
        if(splitItr2 != null)  {
            System.out.println(
                    "Результат, выводимый итератором splitItr2: "
            );
            splitItr2.forEachRemaining(System.out::println);
        }

        //а теперь воспользоваться итератором spliterator
        System.out.println(
                "\nРезультат, выводимый итератором spliterator: "
        );
        spliterator.forEachRemaining(System.out::println);
    }
}

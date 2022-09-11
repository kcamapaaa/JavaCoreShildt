package main.java.com.Vladislav.javacore.chapter29;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        //создать списочный массив значений типа Integer
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Исходный список: " + myList);

        //получить поток элементов списочного массива
        Stream<Integer> myStream = myList.stream();

        //Получить минимальное и максимальное значения,
        //вызвав методы min(), max(), isPresent() и get()
        Optional<Integer> minVal = myStream.min(Integer::compare);
        minVal.ifPresent(n -> System.out.println("Минимальное значение: " + n));

        //непременно получить новый поток данных,
        //поскольку предыдущий вызов метода min()
        //стал оконченой операцией, употребившей поток данных
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        maxVal.ifPresent(n -> System.out.println("Максимальное значение: " + n));

        Stream<Integer> sortedStream = myList.stream().sorted();

        //отобразить отсортированный поток данных,
        //вызвав метод forEach()
        System.out.println("Отсортированный поток данных: ");
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        //вывести только нечетные целочисленные значения,
        //вызвав метод filter()
        Stream<Integer> oddVals = myList.stream().sorted()
                                    .filter(n -> n % 2 != 0);
        System.out.println("Нечетные значение: ");
        oddVals.forEach(n -> System.out.print(n + " "));
        System.out.println();

        //вывести только те нечетные целочисленные значения,
        //которые больше 5. Обратите внимание на
        //конвейеризацию обеих операций фильтрации

        Stream<Integer> oddValsBiggerThan5 = myList.stream().sorted()
                                            .filter(n -> n % 2 != 0)
                                            .filter(k -> k > 5);
        System.out.println("Нечетные значения больше 5: ");
        oddValsBiggerThan5.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}

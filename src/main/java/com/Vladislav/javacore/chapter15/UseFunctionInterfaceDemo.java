package main.java.com.Vladislav.javacore.chapter15;

//Использовать предопределенный функциональный
//интерфейс Function

//импортировать функциональный интерфейс Function
import java.util.function.Function;

public class UseFunctionInterfaceDemo {
    public static void main(String[] args) {

        /*
        Это блочное лямбда-выражение вычисляет факториа
        //целочисленного значения. Для этой цели на сей раз
        //испольхуется функциональный интерфейс Function
         */

        Function<Integer, Integer> factorial = n -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        System.out.println("Факториал числа 3 равен" + factorial.apply(3));
        System.out.println("Факториал числа 5 равен" + factorial.apply(5));
    }
}

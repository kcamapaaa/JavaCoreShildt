package main.java.com.Vladislav.javacore.chapter15;

//Еще один функциональный интерфейс
interface NumericTest {
    boolean test(int n);
}

public class LambdaDemo2 {
    public static void main(String[] args) {
        //Лямбда-выражение, в котором проверяется,
        //является ли число четным

        NumericTest isEven = (n) -> n % 2 == 0;

        if(isEven.test(10)) {
            System.out.println("10 is even!");
        }
        if(!isEven.test(9)) {
            System.out.println("9 is odd");
        }

        //А теперь воспользоваться лямбда-выражением,
        //в котором проверяется, является ли число
        //неотрицательным
        NumericTest isNonNegative = (n) -> n >= 0;

        if(isNonNegative.test(1)) {
            System.out.println("Number 1 is non negative");
        }
        if(!isNonNegative.test(-1)) {
            System.out.println("Number (-1) is negative");
        }
    }
}

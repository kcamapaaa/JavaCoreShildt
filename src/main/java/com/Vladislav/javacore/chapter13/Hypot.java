package main.java.com.Vladislav.javacore.chapter13;

//Воспользоваться статическим импортом для доступа к встроенным в Java
//методам sqrt() and pow()

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

//Вычислить гиппотенузу прямоугольного треугольника

public class Hypot {
    public static void main(String[] args) {
        double side1, side2;
        double hypot;

        side1 = 3.0;
        side2 = 4.0;

        //Здесь методы pow() and sqrt() можно вызвать, опуская имя класса

        hypot = sqrt(pow(side1, 2) + pow(side2, 2));

        System.out.println("Hypot = " + hypot);
    }
}

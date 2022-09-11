package main.java.com.Vladislav.javacore.chapter20;

import java.util.Scanner;

public class AvgNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        double sum = 0.0;

        System.out.println("Введите числа для подсчета среднего.");

        //читать и суммировать числовые значения
        while(scanner.hasNext()) {
            if(scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
                count++;
            } else {
                String str = scanner.next();
                if(str.equals("готово")) {
                    break;
                } else {
                    System.out.println("Ошибка формата данных.");
                    return;
                }
            }
        }
        scanner.close();
        System.out.printf("Среднее равно: %.2f", sum/count);
    }
}

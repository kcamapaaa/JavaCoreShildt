package main.java.com.Vladislav.javacore.chapter20;

import java.util.Random;

public class RandDemo {
    public static void main(String[] args) {
        Random r = new Random();
        double val;
        double sum = 0;
        int[] bell = new int[10];

        for (int i = 0; i < 100; i++) {
            val = r.nextGaussian();
            sum += val;
            double t = -2;

            for (int j = 0; j < 10; j++, t += 0.5) {
                if (val < t) {
                    bell[j]++;
                    break;
                }
            }
        }
        System.out.println("Среднее всех значений: " + (sum / 100));
        //вывести кривую распределения
        for (int j = 0; j < 10; j++) {
            for (int x = bell[j]; x > 0; x--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


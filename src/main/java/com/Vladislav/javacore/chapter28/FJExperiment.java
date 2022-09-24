package main.java.com.Vladislav.javacore.chapter28;

/*
Простой пример программы, позволяющей
эксперементировать с эффектом от изменения
порогового значения и уровня параллелизма
выполнения задач в классе ForkJoinTask
 */

/*
Класс ForkJoinTask преобразует
(через класс RecursiveAction)
элементы массива типа double
 */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class Transform extends RecursiveAction {

    int seqThreshold;

    double[] data;

    int start, end;

    Transform(double[] data, int start, int end, int seqThreshold) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.seqThreshold = seqThreshold;
    }

    protected void compute() {
        if((end - start) < seqThreshold) {
            for(int i = start; i < end; i++) {
                if((data[i] % 2) == 0) {
                    data[i] = Math.sqrt(data[i]);
                } else {
                    data[i] = Math.cbrt(data[i]);
                }
            }
        } else {
            int middle = (end + start) / 2;

            invokeAll(new Transform(data, start, middle, seqThreshold),
                    new Transform(data, middle, end, seqThreshold));
        }
    }
}
public class FJExperiment {
    public static void main(String[] args) {
        int pLevel;
        int threshold;

        if(args.length != 2) {
            System.out.println("Использование: FJExperiment параллелизм порог");
            return;
        }

        pLevel = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[1]);

        //Эти переменные используются для измерения
        //времени выполнения задачи
        long beginT, endT;

        //Создать пул задач. Обратите внимание
        //на установку уровня параллелизма

        ForkJoinPool fjp = new ForkJoinPool(pLevel);

        double[] nums = new double[1_000_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        Transform task = new Transform(nums, 0, nums.length, threshold);

        //начать измерение врмени выполнения задачи
        beginT = System.nanoTime();

        //запустить главную задачу типа ForkJoinTask
        fjp.invoke(task);

        //завершить измерение времени выполнения задачи
        endT = System.nanoTime();

        System.out.println("Уровень параллелизма: " + pLevel);
        System.out.println("Порог последовательной обработки: " + threshold);
        System.out.println("Истекшее время: " + (endT - beginT) + " нс");
        System.out.println("Уровень параллелизма: " + pLevel);
    }





















}

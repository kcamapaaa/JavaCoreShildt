package main.java.com.Vladislav.javacore.chapter28;

//Класс RecursiveTask, используемый для вычисления
//суммы значений элементов в массиве типа double

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Sum2 extends RecursiveTask<Double> {
    final int seqThreshold = 500;

    double[] data;

    int start, end;

    Sum2(double[] vals, int start, int end) {
        this.data = vals;
        this.start = start;
        this.end = end;
    }

    //определить сумму значений элементов в массиве типа double
    @Override
    protected Double compute() {
        double sum = 0;

        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            int middle = (end + start) / 2;

            Sum2 subTaskA = new Sum2(data, start, middle);
            Sum2 subTaskB = new Sum2(data, middle, end);

            //запустить каждую подзадачу путем разветвления
            subTaskA.fork();
            subTaskB.fork();

            //ожидать завершения подзадач и накопить результаты
            sum = subTaskA.join() + subTaskB.join();
        }
        //возвратить конечную сумму
        return sum;
    }
}

public class RecurTaskDemo {
    public static void main(String[] args) {
        //создать пул задач
        ForkJoinPool fjp = new ForkJoinPool();
        double[] nums = new double[5000];

        //инициализировать массив чередующимися числами
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i % 2 == 0) ? i : -i;
        }
        Sum2 task = new Sum2(nums, 0, nums.length);

        /*
        Запустить задачи типа ForkJoinTask. Обратите внимание
        на то, что в данном случае метод invoke()
        возвращает результат
         */

        double summation = fjp.invoke(task);
        System.out.println("Суммирование: " + summation);
    }
}

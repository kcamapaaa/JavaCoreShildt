package main.java.com.Vladislav.javacore.chapter28;

import java.util.concurrent.atomic.AtomicInteger;

//простой пример выполнения атомарных операций
public class AtomicDemo {
    public static void main(String[] args) {
        new Thread(new AtomThread("A")).start();
        new Thread(new AtomThread("B")).start();
        new Thread(new AtomThread("C")).start();
    }
}

class Shared2 {
    static AtomicInteger ai = new AtomicInteger(0);
}

//поток исполнения, в котором инкрементируется значение счетчика
class AtomThread implements Runnable {
    String name;

    AtomThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + name);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Поток " + name + " получено: " + Shared2.ai.getAndSet(i));
        }
    }






}

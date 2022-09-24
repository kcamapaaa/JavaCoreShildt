package main.java.com.Vladislav.javacore.chapter28;

import java.util.concurrent.Semaphore;

public class SemDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        new Thread(new IncThread(sem, "A")).start();
        new Thread(new DecThread(sem, "B")).start();
    }
}

//общий ресурс
class Shared {
    static int count = 0;
}

//Поток исполнения, увеличивающий значение счетчика на единицу
class IncThread implements Runnable {
    String name;
    Semaphore sem;

    IncThread(Semaphore s, String n) {
        name = n;
        sem = s;
    }

    public void run() {

        System.out.println("Запуск потока " + name);
        try {
            //сначала получить разрешение
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение");
            //а теперь получить доступ к общему ресурсу
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                //разрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        //освободить разрешение
        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}

//Поток исполнения, уменьшающий значение
//счетчика на единицу

class DecThread implements Runnable {
    String name;
    Semaphore sem;

    DecThread(Semaphore s, String n) {
        name = n;
        sem = s;
    }

    public void run() {
        System.out.println("Запуск потока " + name);

        try {
            //сначала получить разрешение
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение");
            //а теперь получить доступ к общему ресурсу
            for (int i = 5; i > 0; i--) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                //разрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        //освободить разрешение
        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}

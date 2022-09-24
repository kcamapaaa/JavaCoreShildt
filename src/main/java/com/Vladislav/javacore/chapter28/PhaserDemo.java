package main.java.com.Vladislav.javacore.chapter28;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phsr = new Phaser(1);
        int curPhase;

        System.out.println("запуск потоков");

        new Thread(new MyThread2(phsr, "A")).start();
        new Thread(new MyThread2(phsr, "B")).start();
        new Thread(new MyThread2(phsr, "C")).start();

        //ожидать завершения всеми потоками исполнения первой фазы
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        //ожидать завершения всеми потоками исполнения второй фазы
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        //снять основной поток исполнения с регистрации
        phsr.arriveAndDeregister();

        if(phsr.isTerminated()) {
            System.out.println("Синхронизатор фаз завершен");
        }
    }
}

//Поток исполнения, применяющий синхронизатор фаз типа Phaser
class MyThread2 implements Runnable {
    Phaser phsr;
    String name;

    MyThread2 (Phaser p, String n) {
        phsr = p;
        name = n;
        phsr.register();
    }

    @Override
    public void run() {

        System.out.println("Поток " + name + " начинает первую фазу");
        phsr.arriveAndAwaitAdvance(); //известить о достижении фазы

        /*
        Небольшая пауза, чтобы не нарушить порядок вывода.
        Это сделано только для целей демонстрации, но
        совсем не обязательно для правильного
        функционирования синхронизатора фаз
         */

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Поток " + name + " начинает вторую фазу");
        phsr.arriveAndAwaitAdvance(); // известить о достижении фазы

        /*
        Небольшая пауза, чтобы не нарушить порядок вывода.
        Это сделано только для целей демонстрации, но
        совсем не обязательно для правильного
        функционирования синхронизатора фаз
         */
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Поток " + name + " начинает третью фазу");
        phsr.arriveAndDeregister(); //известить о достижении фазы и снять потоки с регистрации
    }
}
















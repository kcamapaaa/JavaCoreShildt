package main.java.com.Vladislav.javacore.chapter11;

//создание второго потока исполнения, расширив класс Thread
public class NewThread2 extends Thread {

    NewThread2() {
        //создать новый поток исполнения
        super("Демонстрационный поток");

        System.out.println("Дочерний поток: ");
        start();
    }

    //Точка входа во второй поток исполнения
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочерний поток прерван.");
        }
        System.out.println("Дочерний поток завершен.");
    }
}

class ExtendThread {
    public static void main(String[] args) {
        new NewThread2(); //создать поток исполнения

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван.");
        }
        System.out.println("Главный поток завершен.");
    }
}

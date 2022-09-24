package main.java.com.Vladislav.javacore.chapter11;

//Приостановка и возобновление исполнения
//потока современным способом

class NewThread5 implements Runnable {
    String name; //имя потока исполнения
    Thread t;
    boolean suspendFlag;

    NewThread5(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        suspendFlag = false;
        t.start(); //запустить поток исполнения
    }

    //точка входа в поток исполнения
    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while(suspendFlag){
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}

public class SuspendResume {
    public static void main(String[] args) {
        NewThread5 ob1 = new NewThread5("Odin");
        NewThread5 ob2 = new NewThread5("Dva");

        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Priostanovka potoka Odin");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Vozobnovlenie potoka Odin");
            ob2.mysuspend();
            System.out.println("Priostanovka potoka Dva");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Vozobnovlenie potoka Dva");
        } catch (InterruptedException e) {
            System.out.println("Glavniy potok prervan");
        }

        //ожидать завершения потоков исполнения
        try {
            System.out.println("Ожидание завершения потоков.");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Glavniy potok prervan");
        }
        System.out.println("Glavniy potok zavershen");
    }
}

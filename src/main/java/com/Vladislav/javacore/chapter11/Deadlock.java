package main.java.com.Vladislav.javacore.chapter11;

//Пример взаимной блокировки
class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " вошел в метод A.foo()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Класс A прерван.");
        }
        System.out.println(name + " пытается вызвать метод B.last()");
        b.last();
    }
    synchronized void last() {
        System.out.println("В методе А.last()");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в метод B.bar()");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Класс В прерван");
        }

        System.out.println(name + " пытается вызвать метод А.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("В методе А.last()");
    }
}


public class Deadlock implements Runnable{
    A a = new A();
    B b = new B();

    Deadlock() {
        Thread.currentThread().setName("Главный поток.");
        Thread t = new Thread(this, "Соперничающий поток");
        t.start();

        a.foo(b); //получить блокировку для объекта а
                  //в данном потоке исполнения
        System.out.println("Назад в главный поток");
    }

    @Override
    public void run() {
        b.bar(a); //получить блокировку для объекта b
                  //в дрегом потоке исполнения
        System.out.println("Назад в другой поток");
    }

    public static void main(String[] args) {
        new Deadlock();
    }
}

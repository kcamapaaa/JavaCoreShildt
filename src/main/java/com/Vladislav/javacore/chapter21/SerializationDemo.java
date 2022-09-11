package main.java.com.Vladislav.javacore.chapter21;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        //произвести сериализацию обЪекта

        try (ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Vlad\\Desktop\\serial.txt"))) {
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("object1: " + object1);

            objOStrm.writeObject(object1);
        } catch (IOException e) {
            System.out.println("Исключение при сериализации: " + e);
        }

        //произвести десереализацию объекта
        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("C:\\Users\\Vlad\\Desktop\\serial.txt"))) {
            MyClass object2 = (MyClass)objIStrm.readObject();
            System.out.println("object2: " + object2);
        } catch (Exception e) {
            System.out.println("Исключение при десериализации: " + e);
            System.exit(0);
        }
    }
}

class MyClass implements Serializable {
    transient String s;
    int i;
    double d;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "s='" + s + '\'' +
                ", i=" + i +
                ", d=" + d +
                '}';
    }
}

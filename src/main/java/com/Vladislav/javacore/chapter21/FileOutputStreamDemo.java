package main.java.com.Vladislav.javacore.chapter21;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n to come to the aid of their" +
                "country\nand pay their due taxes.";

        byte[] buf = source.getBytes();

        try (FileOutputStream f0 = new FileOutputStream("C:\\Users\\Vlad\\Desktop\\file1.txt");
        FileOutputStream f1 = new FileOutputStream("C:\\Users\\Vlad\\Desktop\\file2.txt");
        FileOutputStream f2 = new FileOutputStream("C:\\Users\\Vlad\\Desktop\\file3.txt")) {

            // записать данные в первый файл
            for (int i = 0; i < buf.length; i+=2) {
                f0.write(buf[i]);
            }

            //записать данные во второй файл
            f1.write(buf);

            //записать данные в третий файл
            f2.write(buf, buf.length*3/4, buf.length/4);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }

    }
}

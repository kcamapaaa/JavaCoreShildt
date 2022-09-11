package main.java.com.Vladislav.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile3 {
    public static void main(String[] args) {
        int i;

        if(args.length != 1) {
            System.out.println("Использование: ShowFile kek3.txt");
            return;
        }

        //Ниже оператор try с ресурсами применяется
        //сначала для открытия, а затем для автоматического
        //закрытия файла по завершению блока этого оператора
        try(FileInputStream fin = new FileInputStream(args[0])) {
            do {
                i = fin.read();
                if(i != -1) {
                    System.out.println(i);
                }
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException e) {
            System.out.println("произошла ошибка ввода вывода.");
        }
    }
}

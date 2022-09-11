package main.java.com.Vladislav.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin;

        //сначала убедиться, что имя файла указано
        if (args.length != 1) {
            System.out.println("Использование: ShowFile kek.txt");
            return;
        }

        //Попытка открыть файл
        try {
            fin = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл");
            return;
        }

        //Теперь файл открыт и готов к чтению.
        //Далее из него читаются символы до тех пор,
        //пока не встретися признак конца файла

        try {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.println((char) i);
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла.");
        } finally {
            //закрыть файл при выходе из блока оператора try
            try {
                fin.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла.");
            }
        }

        //Закрыть файл
        try {
            fin.close();
        } catch (IOException e) {
            System.out.println("Ошибка закрытия файла.");
        }
    }
}

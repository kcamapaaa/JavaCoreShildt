package main.java.com.Vladislav.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile2 {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;

        if(args.length != 1) {
            System.out.println("Использование: ShowFile kek3.txt");
            return;
        }

        //В следующем фрагменте кода сначала открывается файл,
        //а затем из него читаются символы до тех пор, пока
        //не встретится признак конца файла
        try {
            fin = new FileInputStream(args[0]);

            do {
                i = fin.read();
                if(i != -1) {
                    System.out.println((char) i);
                }
            } while (i != -1);
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        } finally {
            try {
                if(fin != null) {
                    fin.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}

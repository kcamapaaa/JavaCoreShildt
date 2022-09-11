package main.java.com.Vladislav.javacore.chapter20;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScanMixed {
    public static void main(String[] args) throws IOException {
        int i;
        double d;
        boolean b;
        String str;

        //вывести данные в файл
        FileWriter fileWriter = new FileWriter("C:\\Users\\Vlad\\Desktop\\file1.txt");
        fileWriter.write("Тестирование Scanner 10 12,2 один true два false");
        fileWriter.close();

        FileReader fileReader = new FileReader("C:\\Users\\Vlad\\Desktop\\file1.txt");

        Scanner scanner = new Scanner(fileReader);

        //прочитать данные до конца файла
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
                System.out.println("int: " + i);
            } else if (scanner.hasNextBoolean()) {
                b = scanner.nextBoolean();
                System.out.println("boolean: " + b);
            } else if(scanner.hasNextDouble()) {
                d = scanner.nextDouble();
                System.out.println("double: " + d);
            } else {
                str = scanner.next();
                System.out.println("String: " + str);
            }
        }

    }
}

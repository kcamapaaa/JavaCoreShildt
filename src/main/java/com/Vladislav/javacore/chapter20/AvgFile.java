package main.java.com.Vladislav.javacore.chapter20;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AvgFile {
    public static void main(String[] args) throws IOException {
        int count = 0;
        double sum = 0;

        //вывести данные в файл
        FileWriter fileWriter = new FileWriter("C:\\Users\\Vlad\\Desktop\\file1.txt");
        fileWriter.write("2 3,4 4 5 6 7 9,1 10,2 готово");
        fileWriter.close();
        FileReader fileReader = new FileReader("C:\\Users\\Vlad\\Desktop\\file1.txt");
        Scanner scanner = new Scanner(fileReader);

        //читать и суммировать числовые значения
        while(scanner.hasNext()) {
            if(scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
                count++;
            } else {
                String str = scanner.next();
                if(str.equals("готово")) {
                    break;
                } else {
                    System.out.println("Ошибка формата файла.");
                    return;
                }
            }
        }
        scanner.close();
        System.out.println("Среднее равно: " + sum/count);
    }
}

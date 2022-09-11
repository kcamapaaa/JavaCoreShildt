package main.java.com.Vladislav.javacore.chapter20;

//Использовать класс Scanner для вычисления среднего из списка чисел, разделяемых запятыми

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SetDelimeters {
    public static void main(String[] args) throws IOException {
        int count = 0;
        double sum = 0;

        //вывести данные в файл
        FileWriter fileWriter = new FileWriter("C:\\Users\\Vlad\\Desktop\\file1.txt");

        //а теперь сохранить данные в списке,
        //разделив их запятыми
        fileWriter.write("2, 3,4, 5,6, 7,4, 9,1, 10,5, готово");
        fileWriter.close();

        FileReader fileReader = new FileReader("C:\\Users\\Vlad\\Desktop\\file1.txt");
        Scanner scanner = new Scanner(fileReader);

        //установать в качестве разделителя запятые и пробелы
        scanner.useDelimiter(", *");

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
                    System.out.println("Ошибка формата файла");
                    return;
                }
            }
        }
        scanner.close();
        System.out.println("Среднее равно: " + sum/count);
    }
}

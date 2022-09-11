package main.java.com.Vladislav.javacore.chapter21;

import java.io.*;

public class DataIODemo {
    public static void main(String[] args) throws IOException {

        //сначала вывести данные в файл
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("C:\\Users\\Vlad\\Desktop\\file3.txt"))) {
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);
        } catch (FileNotFoundException e) {
            System.out.println("Can not open the file");
        } catch (IOException e) {
            System.out.println("Input output error");
        }

        //а теперь ввести данные из файла
        try (DataInputStream din = new DataInputStream(new FileInputStream("C:\\Users\\Vlad\\Desktop\\file3.txt"))) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();

            System.out.println("Получаем значения: " + d + " " + i + " " + b);
        } catch (FileNotFoundException e) {
            System.out.println("can not open the file");
        } catch (IOException e) {
            System.out.println("Input output error");
        }
    }
}

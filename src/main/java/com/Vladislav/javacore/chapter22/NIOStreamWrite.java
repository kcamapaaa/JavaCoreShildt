package main.java.com.Vladislav.javacore.chapter22;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class NIOStreamWrite {
    public static void main(String[] args) {

        //открыть файл и получить связанный с ним поток вывода
        try (OutputStream fout = new BufferedOutputStream(Files.newOutputStream(Paths.get("kek3.txt")))) {
            //вывести в поток заданное количество байтов
            for (int i = 0; i < 26; i++) {
                fout.write((byte) ('a' + i));
            }
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указателя пути " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}

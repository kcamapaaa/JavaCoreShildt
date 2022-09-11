package main.java.com.Vladislav.javacore.chapter22;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ShowFile {
    public static void main(String[] args) {
        int i;

        //сначала удостовериться, что указано имя файл
        if(args.length != 1) {
            System.out.println("Применение: ShowFile имя_файла");
            return;
        }

        //открыть файл и получить связанный с ним поток ввода-вывода
        try (BufferedInputStream fin = new BufferedInputStream(Files.newInputStream(Paths.get(args[0])))) {
            do {
                i = fin.read();
                if(i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);
        } catch (InvalidPathException e) {
            System.out.println("Path error^ " + e);
        } catch (IOException e) {
            System.out.println("IOexceptio: " + e);
        }
    }
}

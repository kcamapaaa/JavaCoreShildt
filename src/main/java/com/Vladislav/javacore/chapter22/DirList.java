package main.java.com.Vladislav.javacore.chapter22;

import java.awt.*;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList {
    public static void main(String[] args) {
        String dirname = "C:\\Users\\Vlad\\Desktop";

        //получить и обработать поток ввода каталога
        //в блоке оператора try
        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirname))) {
            System.out.println("Directory: " + dirname);

            //Класс DirectoryStream реализует
            //интерфейс Iterable, поэтому для вывода
            //содержимого каталога можно организовать цикл for
            //в стиле for each

            for(Path entry : dirstrm) {
                BasicFileAttributes attributes = Files.readAttributes(entry, BasicFileAttributes.class);
                if(attributes.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("      ");
                System.out.println(entry.getName(3));
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}

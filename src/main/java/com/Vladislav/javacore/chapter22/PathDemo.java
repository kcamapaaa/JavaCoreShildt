package main.java.com.Vladislav.javacore.chapter22;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class PathDemo {
    public static void main(String[] args) {
        Path filepath = Paths.get("C:\\Users\\Vlad\\Desktop\\kek3.txt");

        System.out.println("Имя файла: " + filepath.getName(1));
        System.out.println("Путь к файлу: " + filepath);
        System.out.println("Абсолютный путь к файлу: " + filepath.toAbsolutePath() );
        System.out.println("Родительский каталог: " + filepath.getParent());

        if(Files.exists(filepath)) {
            System.out.println("File is exist");
        } else {
            System.out.println("File does not exist");
        }

        try {
            if(Files.isHidden(filepath)) {
                System.out.println("File is hidden");
            } else {
                System.out.println("File is not hidden");
            }
        } catch (IOException e) {
            System.out.println("Error");
        }

        Files.isWritable(filepath);
        System.out.println("File is writtable");

        Files.isReadable(filepath);
        System.out.println("File is readable");

        try {
            BasicFileAttributes attributes = Files.readAttributes(filepath, BasicFileAttributes.class);

            if(attributes.isDirectory())
                System.out.println("It is a directory");
            else
                System.out.println("It is not a directory");

            if(attributes.isRegularFile())
                System.out.println("It is a regular file");
            else
                System.out.println("It is not a regular file");

            if(attributes.isSymbolicLink())
                System.out.println("It is a symbolic link");
            else
                System.out.println("It is not a symbolic link");

            System.out.println("Time of last modification: " + attributes.lastModifiedTime());
            System.out.println("File size is: " + attributes.size() + " bytes.");
        } catch (IOException e){
            System.out.println("Error.");
        }
    }
}

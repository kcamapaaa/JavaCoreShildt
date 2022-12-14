package main.java.com.Vladislav.javacore.chapter21;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("C:\\Users\\Vlad\\Desktop\\kek3.txt")) {
            int c;
            while((c = fr.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}

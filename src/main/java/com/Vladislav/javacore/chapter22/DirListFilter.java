package main.java.com.Vladislav.javacore.chapter22;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class DirListFilter {
    public static void main(String[] args) {
        String dirname = "C:\\Users\\Vlad\\Desktop";

        //создать фильтр, возвращающий логическое
        //значение true в отношении доступных
        //для записи файлов

        DirectoryStream.Filter<Path> how =
                new DirectoryStream.Filter<Path>() {
                    @Override
                    public boolean accept(Path filename) throws IOException {
                        if(Files.isWritable(filename)) {
                            return true;
                        }
                        return false;
                    }
                };

        //получить и использовать поток ввода из каталога
        //только доступных для запси файлов
        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirname), how)) {
            System.out.println("Directory: " + dirname);

            for(Path entry : dirstrm) {
                BasicFileAttributes attributes = Files.readAttributes(entry, BasicFileAttributes.class);
                if(attributes.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("      ");

                System.out.println(entry.getName(3));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}

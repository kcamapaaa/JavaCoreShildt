package main.java.com.Vladislav.javacore.chapter21;

import java.io.File;

public class FileDemo {
    static void p (String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        File f1 = new File("C:\\Users\\Vlad\\Desktop\\HelloWorld");
        p("File name: " + f1.getName());
        p("Path: " + f1.getPath());
        p("Absolute path: " + f1.getAbsolutePath());
        p("Parent's catalog: " + f1.getParent());
        p(f1.exists() ? "exits" : "not exist");
        p(f1.canWrite() ? "able to write" : "unable to write");
        p(f1.canRead() ? "able to read" : "unable to read");
        p(f1.isDirectory() ? "is a directory" : "not a directory");
        p(f1.isFile() ? "it is a file" : "it is not a file");
        p(f1.isAbsolute() ? "is absolute" : "is not absolute");
        p("Last modification: " + f1.lastModified());
        p("Size: " + f1.length() + " bytes");
    }
}

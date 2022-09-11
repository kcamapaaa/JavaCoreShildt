package main.java.com.Vladislav.javacore.chapter20;

import java.util.Formatter;

public class FormatDemo {
    public static void main(String[] args) {
        try (Formatter formatter = new Formatter()) {
            formatter.format("Форматировать %s просто %d %f", "средствами Java", 10, 98.6);

            System.out.println(formatter);
        }
    }
}

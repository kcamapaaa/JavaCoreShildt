package main.java.com.Vladislav.javacore.chapter20;

import java.util.StringTokenizer;

public class STDemo {
    static String in = "Название=Java. Полное руководство;" +
            "Автор=Шилдт;" +
            "Издательство=Oracle Press;" +
            "Авторское право=2018";

    public static void main(String[] args) {
        StringTokenizer stringTokenizer = new StringTokenizer(in, "=;");
        while(stringTokenizer.hasMoreTokens()) {
            String key = stringTokenizer.nextToken();
            String val = stringTokenizer.nextToken();
            System.out.println(key + "\t" + val);
        }
    }
}

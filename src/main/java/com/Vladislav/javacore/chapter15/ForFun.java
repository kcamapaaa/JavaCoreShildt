package main.java.com.Vladislav.javacore.chapter15;

import java.util.List;

public class ForFun {
    public static void main(String[] args) {
        List<String> names = List.of("Vasya", "Dima", "Egor", "Sasha");


        for (String e : names) {
            if(e.length() > 4) {
                System.out.println(e);
            }
        }

        System.out.println("*********************");

        names.stream().filter(n -> n.length() > 4).forEach(System.out::println);

    }
}

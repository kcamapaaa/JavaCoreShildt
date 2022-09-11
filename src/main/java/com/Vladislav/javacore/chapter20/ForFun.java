package main.java.com.Vladislav.javacore.chapter20;

import java.util.StringTokenizer;

public class ForFun {
    public static void main(String[] args) {
        StringTokenizer stringTokenizer = new StringTokenizer("Hello, my name, is Vlad;lolkekus", ",;");

        while(stringTokenizer.hasMoreTokens()) {
            System.out.println("Number of tokens: " + stringTokenizer.countTokens());
            System.out.println(stringTokenizer.nextToken());
        }
    }
}

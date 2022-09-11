package main.java.com.Vladislav.javacore.chapter10;

public class ForFun {

    public static void main(String[] args) {
        System.out.println(checkFinally());
    }

    public static int checkFinally () {
        try {
            throw new RuntimeException();
        } finally {
            return 2;
        }
    }
}

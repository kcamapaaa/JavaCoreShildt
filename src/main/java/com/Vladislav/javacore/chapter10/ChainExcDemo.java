package main.java.com.Vladislav.javacore.chapter10;

public class ChainExcDemo {
    static void demoproc() {
        //create exception
        NullPointerException e = new NullPointerException("high level");

        //add a cause
        e.initCause(new ArithmeticException("cause"));

        throw e;
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            //print high level exc
            System.out.println("Exception was caught: " + e);

            //print exception that was cause for high level exc
            System.out.println("Cause: " + e.getCause());
        }
    }
}

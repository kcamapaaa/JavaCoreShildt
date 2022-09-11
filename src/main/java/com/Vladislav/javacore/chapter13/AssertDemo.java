package main.java.com.Vladislav.javacore.chapter13;

public class AssertDemo {
    static int val = 3;

    //возвратить целочисленное значение
    static int gentum() {
        return val--;
    }

    public static void main(String[] args) {
        int n;

        for (int i = 0; i < 10; i++) {
            n = gentum();

            assert  n > 0; //не подтвердится, если n == 0

            System.out.println("n равно " + n);
        }
    }
}

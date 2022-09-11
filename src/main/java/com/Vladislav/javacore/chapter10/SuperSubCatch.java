package main.java.com.Vladislav.javacore.chapter10;

public class SuperSubCatch {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 42 / a;
        } catch (Exception e) {
            System.out.println("Перехват исключений общего класса Exception.");
        }
//        catch (ArithmeticException e) {
//            //ОШИБКА: недостижимый код!
//            System.out.println("Этот код недостижим.");
//        }
    }
}

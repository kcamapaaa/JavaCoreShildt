package main.java.com.Vladislav.javacore.chapter20;

import java.util.Currency;
import java.util.Locale;

public class CurDemo {
    public static void main(String[] args) {
        Currency c;

        c = Currency.getInstance(Locale.US);

        System.out.println("Symbol: " + c.getSymbol());
        System.out.println("Количество цифр в дробной части числа по умолчанию " + c.getDefaultFractionDigits());
    }
}

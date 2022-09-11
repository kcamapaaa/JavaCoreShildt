package main.java.com.Vladislav.javacore.chapter15;
//Блочное выражение, изменяющее на обратный
//порядок следования символов в троке

interface StringFunc {
    String func(String n);
}

public class BlockLambdaDemo2 {
    public static void main(String[] args) {

        //Это блочное выражение изменяет на обратный
        //порядок следования символов в строке
        StringFunc reverse = str -> {
            StringBuilder result = new StringBuilder();
            int i;

            for (int j = str.length()-1; j >= 0 ; j--) {
                result.append(str.charAt(j));
            }
            return result.toString();
        };

        System.out.println("Лямбда обращается на " + reverse.func("Лямбда"));
        System.out.println("Выражение обращается на " + reverse.func("Выражение"));
    }
}

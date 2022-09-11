package main.java.com.Vladislav.javacore.chapter15;
    //Продемонстрировать ссылку на статический метод

    //Функциональный интерфейс для операций
    //над символьными строками


    interface StringFunc3 {
        String func(String n);
    }

    //В этом классе определяется статический
    //метод strReverse()
    class MyStringOps {
        //Статический метод, изменяющий порядок
        //следования символов в троке
        static String strReverse(String str) {
            String result = "";
            int i;

            for (int j = str.length() - 1; j >= 0; j--) {
                result += str.charAt(j);
            }
            return result;
        }
    }

public class MethodRefDemo {
    //В этом методе функциональный интерфейс
    //указывается в качестве типа первого его
    //парметра. Следовательно, ему может быть
    //передан любой экземпляр данного интерфейса,
    //включая ссылку на метод

    static String stringOp(StringFunc3 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда выражения повышают эффективность Java";
        String outStr;

        //Здесь ссылка на метод strReverse() передается
        //методу stringOp()

        outStr = stringOp(MyStringOps::strReverse, inStr);

        System.out.println("Исходящая строка: " + inStr);
        System.out.println("Обращенная строка строка: " + outStr);
    }
}
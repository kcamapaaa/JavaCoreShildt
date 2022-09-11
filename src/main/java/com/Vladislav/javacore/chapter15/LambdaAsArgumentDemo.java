package main.java.com.Vladislav.javacore.chapter15;

//Передать лямбда-выражение в качестве аргумента
//вызываемому методу

interface StringFunc2 {
    String func(String n);
}

public class LambdaAsArgumentDemo {

    //Первый параметр этого метода имеет тип
    //функционального интерфейса. Следовательно, ему
    //можно передать ссылку на любой экземпляр этого
    //интерфейса, включая экземпляр, создаваемый в
    //лямбда выражении. А второй параметр обозначает
    //обрабатываемую символьную строку

    static String stringOp(StringFunc2 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;

        System.out.println("Это исходная строка: " + inStr);

        //Ниже приведено простое лямбда-выражение
        //преобразующее в прописные все буквы в исходной
        //строке, передаваемой методу stringOp()
        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("Это строка прописными буквами: " + outStr);

        //Ф здесь передается блочное лямбда-выражение,
        //удаляющее пробелы из исходной символьной строки
        outStr = stringOp((str) -> {
            String result = "";
            int i;

            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) != ' ')
                    result += str.charAt(j);
            }
            return result;
        }, inStr);

        System.out.println("Это строка с удаленными пробелами: " + outStr);

        //Можно, конечно, передать и экземпляр
        //функционального интерфейса StringFunc,
        //созданный в предыдущем лямбда выражении.
        //Например, после следующего объявления ссылка
        //reverse делается на экземпляр
        //интерфейса StringFunc

        StringFunc2 reverse = str -> {
            String result = "";
            int i;

            for (int j = str.length() - 1; j >= 0; j--) {
                result += str.charAt(j);
            }
            return result;
        };

        //А теперь ссылку reverse можно передать в
        //качестве первого параметра методу stringOp(),
        //поскольку она делается на объект типа StringFunc
        System.out.println("Это обращенная трока: " + stringOp(reverse, inStr));
    }
}

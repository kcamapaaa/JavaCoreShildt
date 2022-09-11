package main.java.com.Vladislav.javacore.chapter15;

/*
Использовать ссылку на метод экземпляра
вместе с разными объектами

Функциональный интерфейс с методом,
принимающим
два ссылочных аргумента и
возвращающим логическое значение
 */

interface MyFunc2<T> {
    boolean func(T v1, T v2);
}

//Класс для хранения максимальной температуры за день
class HighTemp {
    private int hTemp;

    HighTemp(int ht) {
        hTemp = ht;
    }

    /*
    Возвращать логическое значение true, если
    вызывающий объект типа HighTemp содержит такую
    же температура, как и у объекта h2
     */

    boolean sameTemp(HighTemp ht2) {
        return hTemp == ht2.hTemp;
    }

    /*
    Возвратить логическое значение true, если
    вызывающий объект типа HighTemp содержит
    температуру ниже, чем у объекта ht2
     */

    boolean lessThanTemp(HighTemp ht2) {
        return hTemp < ht2.hTemp;
    }
}


public class InstanceMethWithObjectDemo {
    /*
    Метод, возвращающий количество экземпляров объекта,
    найденныъ по критериям, задаваемым параметром
    функционального интерфейса MyFunc
     */

    static <T> int counter(T[] vals, MyFunc2<T> f, T v) {
        int count = 0;

        for (int i = 0; i < vals.length; i++) {
            if(f.func(vals[i], v)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count;

        //создать массив объектов типа HighTemp
        HighTemp[] weekDayHigh = {
                new HighTemp(89), new HighTemp(82),
                new HighTemp(90), new HighTemp(89),
                new HighTemp(89), new HighTemp(91),
                new HighTemp(84), new HighTemp(83),
        };

        /*
        Использовать метод counter() вместе с массивами
        объектов типа HighTemp. Обратите внимание на то,
        что ссылка на метод экземпляра sameTemp()
        передается в качестве второго параметра
         */
        count = counter(weekDayHigh, HighTemp::sameTemp, new HighTemp(89));
        System.out.println("Дней, когда максимальная температура была 89: " + count);

        //А теперь создать и использовать вместе с данным
        //методом еще один массив объектов типа HighTemp

        HighTemp[] weekDayHigh2 = {
                new HighTemp(32), new HighTemp(12),
                new HighTemp(24), new HighTemp(19),
                new HighTemp(18), new HighTemp(12),
                new HighTemp(-1), new HighTemp(13)
        };

        count = counter(weekDayHigh2, HighTemp::sameTemp, new HighTemp(12));
        System.out.println("Дней, когда максимальная температура была 12: " + count);

        /*
        А теперь воспользоваться методом lessThanTemp(),
        чтобы выяснить, сколько дней температура была
        меньше заданной
         */

        count = counter(weekDayHigh, HighTemp::lessThanTemp, new HighTemp(89));
        System.out.println("Дней, когда максимальная температура была 89: " + count);

        count = counter(weekDayHigh2, HighTemp::lessThanTemp, new HighTemp(19));
        System.out.println("Дней, когда максимальная температура была 19: " + count);
    }
























}

package main.java.com.Vladislav.javacore.chapter15;

//Реализовать простую фабрику классов,
//используя ссылку на конструктор

interface MyFun<R, T> {
    R func(T n);
}

//Простой обобщенный класс
class MyClas<T> {
    private T val;

    //Конструктор, принимающий один параметр
    MyClas (T v) {
        val = v;
    }

    //конструктор по умолчанию. Этот конструктор в данный программе не используется
    MyClas () {
        val = null;
    }

    T getVal() {
        return val;
    }
}

class MyClas2 {
    String str;

    //конструктор, принимающий один аргумент
    MyClas2 (String s) {
        str = s;
    }

    //конструктор по умолчанию. Этот конструктор в данной программе не используется
    MyClas2 () {
        str = null;
    }

    String getVal() {
        return str;
    }
}

public class ConstructorRefDemo3 {

    /*
    Фабричный метод для объектов разных классов.
    У каждого класса должен быть свой конструктор,
    принимающий один параметр типа T. А параметр R
    обозначает типа создаваемого объекта
     */
    static <R, T> R myClassFactory(MyFun<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {
        /*
        Создать ссылку на конструктор класса MyClas.
        Здесь в операции new вызывается конструктор,
        принимающий аргумент
         */

        MyFun<MyClas<Double>, Double> myClassCons = MyClas<Double>::new;

        //создавая экземпляр типа класса MyClass,
        //используя фабричный метод
        MyClas<Double> mc = myClassFactory(myClassCons, 100.1);

        //использовать только что созданный экземпляр
        //класса MyClass
        System.out.println("Значение val в объекте мс равно " + mc.getVal());

        //А теперь создать экземпляр дургого класса, используя метод myClassFactory()
        MyFun<MyClas2, String> myClassCons2 = MyClas2::new;

        MyClas2 mc2 = myClassFactory(myClassCons2, "Hello!");
        System.out.println("Значение val mc = " + mc2.getVal());

    }























}

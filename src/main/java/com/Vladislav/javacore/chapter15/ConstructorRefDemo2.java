package main.java.com.Vladislav.javacore.chapter15;

//Теперь функциональный интерфейс MyFunc5
//объявляется как обобщенный

interface MyFunc5<T> {
    MyClass5<T> func(T n);
}

class MyClass5<T> {
    private T val;

    //Этот конструктор принимает один аргумент
    MyClass5 (T v) {
        val = v;
    }

    //А этот конструктор по умолчанию
    MyClass5 () {
        val = null;
    }

    T getVal() {
        return val;
    }
}

public class ConstructorRefDemo2 {

    public static void main(String[] args) {
        //создать ссылку на конструктор обобщенного
        //класса MyClass<T>
        MyFunc5<Integer> myClassCons = MyClass5<Integer>::new;

        //создать экземпляр класса MyClass<T>
        //по данной ссылку на конструктор
        MyClass5<Integer> mc = myClassCons.func(100);

        //воспользоваться только что созданным
        //экземпляром класса MyClass<T>
        System.out.println("Значение val в объекте mc равно " + mc.getVal());
    }
}

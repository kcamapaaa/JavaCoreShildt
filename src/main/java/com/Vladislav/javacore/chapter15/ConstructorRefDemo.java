package main.java.com.Vladislav.javacore.chapter15;

//В функциональном интерфейсе MyFunc определяется
//метод, возвращающий ссылку на класс MyClass

interface MyFunc4 {
    MyClass1 func(int n);
}

class MyClass1 {
    private int val;

    //Этот конструктор принимает один аргумент
    MyClass1 (int val) {
        this.val = val;
    }

    //А этот конструктор по умолчанию
    MyClass1() {
        this.val = 0;
    }

    public int getVal() {
        return val;
    }
}


public class ConstructorRefDemo {
    public static void main(String[] args) {
        /*
        Создать ссылку на конструктор классф MyClass.
        Метод func() из интерфейса MyFunc4 принимает
        аргумент, поэтому в операции new вызывается
        параметризованный конструктор класса MyClass,
        а не к его конструктору по умолчанию
         */

        MyFunc4 myClassCons = MyClass1::new;

        //создать экземпляр класса MyClass
        //по ссылку на его конструктор
        MyClass1 mc = myClassCons.func(100);

        //Использовать только что созданный экземпляр
        //класса MyClass
        System.out.println("Значение val в объекте мс равно " + mc.getVal() );
    }
}

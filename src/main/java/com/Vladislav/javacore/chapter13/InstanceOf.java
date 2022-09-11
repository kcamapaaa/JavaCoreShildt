package main.java.com.Vladislav.javacore.chapter13;

class A {
    int i, j;
}

class B {
    int i, j;
}

class C extends A {
    int k;
}

class D extends A {
    int k;
}

public class InstanceOf {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        if(a instanceof A)
            System.out.println("a is instance of A");
        if(b instanceof B)
            System.out.println("b is instance of B");
        if(c instanceof C)
            System.out.println("c is instance of C");
        if(c instanceof A)
            System.out.println("c is instance of A");
        if(a instanceof C)
            System.out.println("a is instance of C");

        System.out.println();

        //сравнить с порожденными типами
        A ob;
        ob = d; //ссылка на обьект d
        System.out.println("ob теперь ссылается на d");
        if(ob instanceof D)
            System.out.println("ob является экземпляром D");

        System.out.println();

        ob = c; //ссылка на с
        System.out.println("ob теперь ссылается на с");

        if(ob instanceof D)
            System.out.println("ob можно привязать к типу D");
        else
            System.out.println("ob нельзя привести к типу D");

        if(ob instanceof A)
            System.out.println("ob можно привести к типу А");

        System.out.println();

        //все обьекты могут быть приведены к типу Object
        if(a instanceof Object)
            System.out.println("a is instance of Object");
        if(b instanceof Object)
            System.out.println("b is instance of Object");
        if(c instanceof Object)
            System.out.println("c is instance of Object");
        if(d instanceof Object)
            System.out.println("d is instance of Object");
    }
}

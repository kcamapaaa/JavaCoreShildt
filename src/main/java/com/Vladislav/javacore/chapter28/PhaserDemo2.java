package main.java.com.Vladislav.javacore.chapter28;

/*
Расширить класс Phaser и переопределить
метод onAdvance() таким образом, чтобы было
выполнено только определенное количество фаз
 */

//Расширить класс MyPhaser, чтобы выполнить
//только определенное количество фаз

import java.util.concurrent.Phaser;

class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }

    //переопределить метод onAdvance(), чтобы
    //выполнить определенное количество фаз
    protected boolean onAdvance(int p, int regParties) {
        /* Следующий выхов метода println() требуется только
        для целей иллюстрации. Как правило, метод
        onAdvance() не отображает выводимые данные
        */
        System.out.println("Фаза " + p + " завершена.\n");

        //возвратить логическое значение true,
        //если все фазы завершены
        if(p == numPhases || regParties == 0) {
            return true;
        }
        //В проьтвном случае возвратить логическое
        // значение false
        return false;
    }
}

public class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser phsr = new MyPhaser(1, 4);
        System.out.println("Запуск потоков\n");

        new Thread(new MyThread3(phsr, "A")).start();
        new Thread(new MyThread3(phsr, "B")).start();
        new Thread(new MyThread3(phsr, "C")).start();

        //ожидать завершения определенного количества фаз
        while(!phsr.isTerminated()) {
            phsr.arriveAndAwaitAdvance();
        }

        System.out.println("Синхронизатор фаз завершен");
    }
}

//Поток исполнения, применяющий синхронизатор фаз типа Phaser
class MyThread3 implements Runnable {
    Phaser phsr;
    String name;

    MyThread3(Phaser p, String n) {
        phsr = p;
        name = n;
        phsr.register();
    }

    @Override
    public void run() {

        while(!phsr.isTerminated()) {
            System.out.println("Поток " + name + " начинает фазу " + phsr.getPhase());
            phsr.arriveAndAwaitAdvance();

            /*
            Небольшая пауза, чтобы не нарушить
            порядок вывода. Это сделано только для
            демонстрации, но совсем не обязательно для
            правильного функционирования синхронизатора фаз
             */
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

package main.java.com.Vladislav.javacore.chapter20;

import java.util.Timer;
import java.util.TimerTask;

class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Задание по таймеру выполняется.");
    }
}

public class TTest {
    public static void main(String[] args) {
        MyTimerTask myTimerTask = new MyTimerTask();
        Timer timer = new Timer();

        //установить первоначальную паузу в течение одной секунды,
        //а затем повторять задание каждые полсекунды

        timer.schedule(myTimerTask, 1000, 500);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        timer.cancel();
    }
}

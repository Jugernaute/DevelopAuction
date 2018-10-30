package ua.timer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Timer;
import java.util.TimerTask;

public class Secundomir {
    public static void main(String[] args) {

//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime dateTime_future = LocalDateTime.of(2018, 11, 10, 9, 0, 0);
//        Duration between = Duration.between(now, dateTime_future);
//        long seconds = between.getSeconds();
//        Timer timer=new Timer();
//
//
//        TimerRun timerRun = new TimerRun();
//        timerRun.calculateTime(seconds);
//
//
//        timer.scheduleAtFixedRate(new TimerTask() {
//            public void run() {
//                timerRun.setInterval();
//            }
//        }, 0, 1000);


        int a=0;

        for (int i = 0; i < 5; i++) {
            System.out.println(++a);
        }

    }

}

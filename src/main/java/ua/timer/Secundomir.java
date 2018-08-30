package ua.timer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Timer;
import java.util.TimerTask;

public class Secundomir {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime_future = LocalDateTime.of(2018, 9, 10, 9, 0, 0);
        Duration between = Duration.between(now, dateTime_future);
        long seconds = between.getSeconds();



        TimerRun timerRun = new TimerRun();
        Timer timer=new Timer();
        timerRun.calculateTime(seconds);
//        System.out.println(timerRun.getSec());
//        final Timer timer = new Timer();


//                final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                timerRun.setInterval();
            }
        }, 0, 1000);

    }

}

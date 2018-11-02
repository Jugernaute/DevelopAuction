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


       String [] array = {"qwe","asd", "zxc","rrr","lklk"};
//        int length = array.length;
//        System.out.println(length);
int count=0;
        for (String s : array) {
            ++count;
            do {
                System.out.println("-> "+s);
            }while (count>array.length);
        }

    }

}

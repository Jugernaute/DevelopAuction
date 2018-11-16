package ua.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm {
     Timer timer;

    public Alarm(Date date) {
        timer = new Timer();
        timer.schedule(new AlarmTask(), date);
    }


    class AlarmTask extends TimerTask {
        public void run() {
            System.out.println("Wake up!!!");
            timer.cancel();
        }
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    //    public static void main(String args[]) {
//        Date date = new Date(); //time for alarm
//        long l = date.getTime() + 4000;
//        Date date1 = new Date(l);
//        new Alarm(date1);
//        System.out.println("Alarm is turned on");
//    }
}

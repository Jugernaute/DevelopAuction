package ua.timer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

public class Secundomir {
    public static void main(String[] args) {

        System.out.println(System.getProperty("java.util.logging.config.file"));



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
//=======================================================================================
//        ONewsAgency observable = new ONewsAgency();
//        ONewsChannel observer1 = new ONewsChannel();
//        ONewsChannel observer2 = new ONewsChannel();
//        ONewsChannel observer3 = new ONewsChannel();
//
//        observable.addObserver(observer1);
//        observable.addObserver(observer2);
//        observable.addObserver(observer3);
//        observable.setNews("eeee");
//        observable.setAsd("bb");
////        observable.setNews("qwe");
//
////        Car car = new Car();
////        System.out.println(car.getName());
//
//
//    }
//
//    public static class ONewsChannel implements Observer {
//
////        private String s;
//
//        @Override
//        public void update(Observable o, Object s) {
////            this.setNews((String) s);
////            int i = o.countObservers();
//            System.out.println(s);
//        }
//
////        public String getNews() {
////            return s;
////        }
////
////        public void setNews(String news) {
////            this.s = s;
////        }
//
//    }
//
//
//    public static class ONewsAgency extends Observable {
//        private String news;
//        private String asd;
//
//        public void setNews(String news) {
//            this.news = news;
//            setChanged();
//            notifyObservers(news);
//        }
//
//        public void setAsd(String asd) {
//            this.asd = asd;
//            setChanged();
//            notifyObservers(asd);
//        }



    }

}

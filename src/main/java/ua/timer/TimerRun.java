package ua.timer;
import lombok.*;

import java.util.Timer;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode

public class TimerRun {
    long year;
    long month;
    long days;
    long hours;
    long minutes;
    long sec;

    Timer timer;

    public  void calculateTime(long seconds) {
         sec = seconds % 60;
         minutes = seconds % 3600 / 60;
         hours = seconds % 86400 / 3600;
         days = seconds / 86400;

        System.out.println(days+ "d " + hours + "h " + minutes + "min " + sec + "sec " );
    }


      public long setInterval() {
        if (sec == -1){
            --minutes; sec = 59;
        }if(minutes==-1){
            --hours; minutes = 59;
          } if(hours==-1){
            --days; hours = 23;
          }if(days == 0 && hours==00 && minutes==0 && sec == 0)
            timer.cancel();
        System.out.println(days+ "d " + hours + "h " + minutes + "m " + sec + "s " );
        return --sec;
    }
}

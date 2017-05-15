package se.kth.ict.nextgenpos.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by fredrik on 15/05/17.
 */
public class Time {

    public Time(){}

    public String getCurrentTime(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatted = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return time.format(formatted);
    }
}

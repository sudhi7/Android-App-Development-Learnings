package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateFormater {

    public static String getFormatedDate(long unix_time) {
        Date dateObject = new Date(unix_time);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        return dateFormatter.format(dateObject);
    }

    public static String getFormattedTime(long unix_time) {
        Date dateObject = new Date(unix_time);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("h:mm a");
        return dateFormatter.format(dateObject);
    }

}

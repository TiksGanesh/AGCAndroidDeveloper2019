package com.example.notes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Class:       TimeUtil
 * Description: Utility functin related to Time
 */
public class TimeUtil {

    public static String convertTimeStampToLocalTime(String timestamp){

        long mTimeStamp = Long.parseLong(timestamp);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mTimeStamp);
        Date date = calendar.getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM yyyy HH:mm", Locale.ENGLISH);
        return simpleDateFormat.format(date);
    }
}

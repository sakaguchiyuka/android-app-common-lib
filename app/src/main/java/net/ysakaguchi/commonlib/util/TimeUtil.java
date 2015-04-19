package net.ysakaguchi.commonlib.util;

import android.content.Context;
import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * 時間処理用クラス
 */
public class TimeUtil {

    public static final long MILLISECOND = 1;
    public static final long MILLISECOND_PAR_SECOND = 1000;
    public static final long MILLISECOND_PAR_MINUTE = 1000 * 60;
    public static final long MILLISECOND_PAR_HOUR   = 1000 * 60 * 60;
    public static final long MILLISECOND_PAR_DAY    = 1000 * 60 * 60 * 24;

    public static boolean isHours24(final Context context) {
        return DateFormat.is24HourFormat(context);
    }

    public static int getSubDay(final Date start, final Date end) {
        if (null == start || null == end) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        CalendarUtil.setZeroTime(cal);
        final long startTime = cal.getTimeInMillis();

        cal = Calendar.getInstance();
        cal.setTime(end);
        CalendarUtil.setZeroTime(cal);
        final long endTime = cal.getTimeInMillis();

        return (int) ((endTime - startTime) / MILLISECOND_PAR_DAY);
    }
}

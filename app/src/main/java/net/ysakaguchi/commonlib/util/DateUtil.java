package net.ysakaguchi.commonlib.util;

import android.content.Context;
import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date create() {
        final Calendar cal = Calendar.getInstance();
        CalendarUtil.setZeroTime(cal);
        return new Date(cal.getTimeInMillis());
    }

    public static Date create(final int year, final int monthOfYear, final int dayOfMonth) {
        final Calendar cal = CalendarUtil.create(year, monthOfYear, dayOfMonth);
        CalendarUtil.setZeroTime(cal);
        return new Date(cal.getTimeInMillis());
    }

    public static String getStr(final Context context, final Date date, final int resId) {
        if (null == date || 0 == resId) {
            return null;
        }
        return DateFormat.format(StringUtil.getStr(context, resId), date).toString();
    }
}

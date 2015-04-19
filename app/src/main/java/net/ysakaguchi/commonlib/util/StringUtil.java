package net.ysakaguchi.commonlib.util;

import android.content.Context;

public class StringUtil {
    public static String getStr(final Context context, final int resId, Object... formatArgs) {
        return context.getResources().getString(resId, formatArgs);
    }

    public static boolean isEmpty(final String str) {
        return (null == str || str.isEmpty());
    }

    public static boolean isNotEmpty(final String str) {
        return !isEmpty(str);
    }
}

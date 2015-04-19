package net.ysakaguchi.commonlib.util;

import android.content.Context;
import android.widget.Toast;

/**
 *
 */
public class ToastUtil {
    public static void show(final Context context, final int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
    }

    public static void show(final Context context, final String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static void show(final Context context, final int resId, final Object... formatArgs) {
        Toast.makeText(context, context.getString(resId, formatArgs), Toast.LENGTH_LONG).show();
    }

}

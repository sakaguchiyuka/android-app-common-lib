package net.ysakaguchi.commonlib.util;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class ViewUtil {

    public static View getView(final View v, final int id) {
        if (null == v) {
            return null;
        }
        return v.findViewById(id);
    }

    public static String getText(final View v) {
        if (v instanceof TextView) return ((TextView) v).getText().toString();
        return null;
    }

    public static void setText(final View v, final Context c, final int strId, Object... formatArgs) {
        setText(v, StringUtil.getStr(c, strId, formatArgs));
    }

    public static void setText(final View v, final int resId) {
        if (null == v || resId <= 0) {
            return;
        } else if (v instanceof TextView) {
            ((TextView) v).setText(resId);
        }
    }

    public static void setText(final View v, final String str) {
        if (null == v || null == str) {
            return;
        } else if (v instanceof TextView) {
            ((TextView) v).setText(str);
        }
    }

    public static void addText(final View v, final String str) {
        if (null == v || null == str) {
            return;
        } else if (v instanceof TextView) {
            ((TextView) v).setText((((TextView) v).getText() + str));
        }
    }

    /**
     * colorは{@link android.content.res.Resources#getColor(int)}で得た値を渡す
     */
    public static void setTextColor(final View v, final int color) {
        if (null == v) {
            return;
        } else if (v instanceof TextView) {
            ((TextView) v).setTextColor(color);
        }
    }

    public static void setOnClickListener(final View v, final View.OnClickListener listener) {
        if (null != v) v.setOnClickListener(listener);

    }

    public static void setOnCheckedChangeListener(final View v, final CompoundButton.OnCheckedChangeListener listener) {
        if (null == v || !(v instanceof CompoundButton)) {
            return;
        }
        ((CompoundButton) v).setOnCheckedChangeListener(listener);
    }
    public static void setChecked(final View v, final boolean checked) {
        if (null == v || !(v instanceof CompoundButton)) {
            return;
        }
        ((CompoundButton) v).setChecked(checked);
    }

    public static void setImage(final View v, final int resId) {
        if (null == v || resId <= 0) {
            return;
        } else if (v instanceof ImageView) {
            ((ImageView) v).setImageResource(resId);
        }
    }

    public static void setVisibleOrGone(final View v, final boolean isVisible) {
        if (null != v) v.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    public static void setVisibleOrInvisible(final View v, final boolean isVisible) {
        if (null != v) v.setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
    }

    public static void setEnabled(final View v, final boolean enabled) {
        if (null != v) v.setEnabled(enabled);
    }

    public static void setClickable(final View v, final boolean clickable) {
        if (null != v) v.setClickable(clickable);
    }

    public static int getProgress(final View v, final int defaultValue) {
        if (null == v || !(v instanceof SeekBar)) {
            return defaultValue;
        }
        return ((SeekBar) v).getProgress();
    }
}

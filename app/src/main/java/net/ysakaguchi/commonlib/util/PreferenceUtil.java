package net.ysakaguchi.commonlib.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * データ保存処理用クラス
 */
public class PreferenceUtil {

    public static void putString(final SharedPreferences.Editor editor, final String key, final String value) {
        editor.putString(key, value).commit();
    }

    public static void putBoolean(final SharedPreferences.Editor editor, final String key, final boolean value) {
        editor.putBoolean(key, value).commit();
    }

    public static void putInt(final SharedPreferences.Editor editor, final String key, final int value) {
        editor.putInt(key, value).commit();
    }

    public static void putLong(final SharedPreferences.Editor editor, final String key, final long value) {
        editor.putLong(key, value).commit();
    }

    public static void putFloat(final SharedPreferences.Editor editor, final String key, final float value) {
        editor.putFloat(key, value).commit();
    }

    public static String getString(final SharedPreferences pref, final String key, final String defaultValue) {
        return pref.getString(key, defaultValue);
    }

    public static boolean getBoolean(final SharedPreferences pref, final String key, final boolean defaultValue) {
        return pref.getBoolean(key, defaultValue);
    }

    public static int getInt(final SharedPreferences pref, final String key, final int defaultValue) {
        return pref.getInt(key, defaultValue);
    }

    public static long getLong(final SharedPreferences pref, final String key, final long defaultValue) {
        return pref.getLong(key, defaultValue);
    }

    public static float getFloat(final SharedPreferences pref, final String key, final float defaultValue) {
        return pref.getFloat(key, defaultValue);
    }

    public static void remove(final SharedPreferences.Editor editor, final String key) {
        editor.remove(key);
    }

    public static SharedPreferences getPref(final Context context, final String name, final int mode) {
        return context.getApplicationContext().getSharedPreferences(name, mode);
    }
}

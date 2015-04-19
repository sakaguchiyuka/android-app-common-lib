package net.ysakaguchi.commonlib.util;

public class ObjectUtil {
    public static <T> T get(final T obj, final T def) {
        if (null == obj) {
            return def;
        }
        return obj;
    }
}

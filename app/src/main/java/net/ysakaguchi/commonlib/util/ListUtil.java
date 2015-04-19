package net.ysakaguchi.commonlib.util;

import java.util.List;

public class ListUtil {
    public static <T> boolean isNotEmpty(final List<T> list) {
        return (null != list && !list.isEmpty());
    }

    public static <T> boolean isEmpty(final List<T> list) {
        return !isNotEmpty(list);
    }
}

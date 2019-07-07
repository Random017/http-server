package com.skycong.util;


import java.util.Collection;
import java.util.Map;

/**
 * @author RMC 2018/1/19 17:10
 */
public class Assert {

    /**
     * 断言一个对象不能为空<br>
     * <br>
     * 如果是 string   内容不能为空<br>
     * 如果是 collection  元素个数不能为0<br>
     * 如果是 map   元素个数不能为0<br>
     * 如果是 array 长度不能0<br>
     *
     * @param o   Object
     * @param msg error msg
     * @throws IllegalArgumentException 参数为空抛出的异常
     */
    public static void notNull(Object o, String msg) {
        if (isEmpty(o))
            throw new IllegalArgumentException(msg);
    }


    /**
     * 判断一个obj是否为空<br>
     * <br>
     * 如果是 string   判断内容为空<br>
     * 如果是 collection  判断元素个数为0<br>
     * 如果是 map   判断元素个数为0<br>
     * 如果是 array 判断长度为0<br>
     *
     * @param o 可以是 obj，string，collection，map，array
     * @return string，collection，map，array 没有元素返回true
     */
    public static boolean isEmpty(Object o) {
        if (o == null) return true;
        if (o instanceof CharSequence) {
            return ((CharSequence) o).length() == 0;
        }
        if (o instanceof Collection) {
            return ((Collection) o).isEmpty();
        }
        if (o instanceof Map) {
            return ((Map) o).isEmpty();
        }
        if (o.getClass().isArray()) {
            Object[] os = (Object[]) o;
            return os.length == 0;
        }
        return false;
    }
}



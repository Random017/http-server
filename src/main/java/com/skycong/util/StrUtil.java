package com.skycong.util;


import java.util.Arrays;

/**
 * 字符串处理增强工具
 *
 * @author RMC 2018/4/26 10:35
 */
public class StrUtil {

    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final String CHARSET = "UTF-8";


    public static final String ARRAY_SEPARATOR = ",";

    /**
     * header 中的分隔符冒号
     */
    public static final String HEADER_SPLIT = ":";

    /**
     * 空格
     */
    public static final String BLANK_SPACE = " ";

    /**
     * 行 分隔符
     */
    public static final String LINE_SPLIT = "\r\n";

    /**
     * 块 分隔符
     */
    public static final String BLOCK_SPLIT = "\r\n\r\n";

    /**
     * 自定义 分割符，并剔除空的str
     *
     * @param text
     * @param separator
     * @return
     */
    public static String[] split(String text, String separator) {
        Assert.notNull(text, "text不能为空");
        Assert.notNull(separator, "separator不能为空");
        String[] strings = text.split(separator);
        return Arrays.stream(strings).filter(s -> !s.isEmpty()).toArray(String[]::new);
    }

    /**
     * 将byte 数组转换为十六进制 char 数组
     *
     * @param bytes byte data
     * @return hex char
     */
    public static char[] bytes2HexChars(byte[] bytes) {
        final int l = bytes.length;
        final char[] out = new char[l << 1];
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = HEX_CHARS[(0xF0 & bytes[i]) >>> 4];
            out[j++] = HEX_CHARS[0x0F & bytes[i]];
        }
        return out;
    }
}

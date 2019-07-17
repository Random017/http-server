package com.skycong.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author RMC 2019/7/6 12:00
 */
public class StreamUtil {

    /**
     * 从 inputStream 读取数据，以字符格式返回
     *
     * @param inputStream inputStream
     * @return string
     */
    public static String readFromInputStream(InputStream inputStream) {
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
                if (len < 1024) break;
            }
            baos.flush();
            return baos.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.zmj.tool;

import java.text.SimpleDateFormat;

/**
 * @author ZMJ
 * @Package com.zmj.tool
 * @describe 线程安全的dateformat
 * @date 2023/10/17 14:32
 */
public class SimpleDateFormatUtils {

    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static SimpleDateFormat getTime() {
        SimpleDateFormat simpleDateFormat = THREAD_LOCAL.get();
        if(simpleDateFormat == null){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return simpleDateFormat;
    }
}

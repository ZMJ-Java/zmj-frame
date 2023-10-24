package com.zmj.trace;

import org.slf4j.MDC;

import java.util.UUID;

/**
 * @author ZMJ
 * @Package com.zmj.trace
 * @date 2023/10/24 9:19
 */
public class TraceIdContext {

    public static final ThreadLocal<String> CURRENT_TRACE_ID = new InheritableThreadLocal<>();


    public static String generateTraceId() {
        return UUID.randomUUID().toString();
    }


    public static String getTraceId() {
        return MDC.get(TraceIdConstant.TRACE_ID);

    }


    public static void setTraceId(String traceId) {
        MDC.put(TraceIdConstant.TRACE_ID, traceId);
    }


    public static void clearTraceId() {
        CURRENT_TRACE_ID.set(null);
        CURRENT_TRACE_ID.remove();
    }

}

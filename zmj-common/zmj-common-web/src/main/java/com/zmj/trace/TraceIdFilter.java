package com.zmj.trace;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author ZMJ
 * @Package com.zmj.trace
 * @date 2023/10/24 9:20
 */

@Component
@Slf4j
public class TraceIdFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String traceId = httpServletRequest.getHeader(TraceIdConstant.TRACE_ID);

        if (StringUtils.isBlank(traceId)){
            traceId = TraceIdContext.generateTraceId();
        }

        TraceIdContext.setTraceId(traceId);
        filterChain.doFilter(servletRequest,servletResponse);
        TraceIdContext.clearTraceId();


    }



}

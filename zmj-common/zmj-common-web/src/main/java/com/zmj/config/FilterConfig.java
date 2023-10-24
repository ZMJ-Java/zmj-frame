package com.zmj.config;

import com.zmj.trace.TraceIdFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author ZMJ
 * @Package com.zmj.config
 * @date 2023/10/24 9:17
 */
@Configuration
public class FilterConfig {
    @Resource
    private TraceIdFilter traceIdFilter;

    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(traceIdFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("traceIdFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}

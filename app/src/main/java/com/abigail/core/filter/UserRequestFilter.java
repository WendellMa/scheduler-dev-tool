package com.abigail.core.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import java.util.logging.LogRecord;

@Order(1)
@Slf4j
@WebFilter(filterName = "user-request-id", urlPatterns = "/*")
public class UserRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init user-request-id filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Random random = new Random();
        int randomNum = random.nextInt(1000);
        MDC.put("userId", randomNum + "");
        MDC.put("requestId", UUID.randomUUID().toString());
        filterChain.doFilter(servletRequest, servletResponse);
        MDC.remove("userId");
        MDC.remove("requestId");
    }

    @Override
    public void destroy() {
        log.info("destroy user-request-id filter");
    }
}

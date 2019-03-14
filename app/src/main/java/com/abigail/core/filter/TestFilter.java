package com.abigail.core.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@Order(2)
@Slf4j
@WebFilter(filterName = "test-filter", urlPatterns = "/*")
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init test-filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("before test filter");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("after test filter");
    }

    @Override
    public void destroy() {
        log.info("destroy test-filter");
    }
}

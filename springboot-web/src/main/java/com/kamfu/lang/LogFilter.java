package com.kamfu.lang;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import lombok.extern.log4j.Log4j2;
@Log4j2
@WebFilter(urlPatterns = "/*", filterName = "LogFilter")
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	log.info("LogFilter-init");
    }
 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("LogFilter doFilter cost=" + (System.currentTimeMillis() - start));
    }
 
    @Override
    public void destroy() {
    	log.info("LogFilter-destroy");
    }
}
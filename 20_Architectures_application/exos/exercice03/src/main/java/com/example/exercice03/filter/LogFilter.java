package com.example.exercice03.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Timestamp;

@Component
public class LogFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Log filter");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        String method = req.getMethod();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String ipClient = req.getRemoteAddr();
        System.out.println("URI: " + uri + ", method: " + method + ", timestamp: " + timestamp + ", ipClient: " + ipClient);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

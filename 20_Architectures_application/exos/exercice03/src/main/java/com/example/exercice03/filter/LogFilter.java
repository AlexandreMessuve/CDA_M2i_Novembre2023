package com.example.exercice03.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Timestamp;

@Component
public class LogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("LogFilter");
        String uri = request.getRequestURI();
        System.out.println("uri: " + uri);
        String method = request.getMethod();
        System.out.println("method: " + method);
        System.out.println("Timestamp: " + new Timestamp(System.currentTimeMillis()));
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("ipAddress: " + ip.getHostAddress());
        filterChain.doFilter(request, response);
    }
}

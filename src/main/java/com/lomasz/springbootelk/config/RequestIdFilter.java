package com.lomasz.springbootelk.config;

import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public class RequestIdFilter extends OncePerRequestFilter {

    private static final String X_REQUEST_ID = "X-Request-ID";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String requestId = Optional.ofNullable(request.getHeader(X_REQUEST_ID)).orElse(UUID.randomUUID().toString());
        MDC.put(X_REQUEST_ID, requestId);
        filterChain.doFilter(request, response);

    }

}

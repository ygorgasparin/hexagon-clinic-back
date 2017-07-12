package com.hexagon.clinic.web;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CorsInterceptor extends HandlerInterceptorAdapter {

    private static final String ORIGIN_NAME = "Access-Control-Allow-Origin";
    private static final String METHODS_NAME = "Access-Control-Allow-Methods";
    private static final String HEADERS_NAME = "Access-Control-Allow-Headers";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader(ORIGIN_NAME, "*");
        response.setHeader(HEADERS_NAME, "Content-Type, Content-Length, Authorization, Accept,X-Requested-With");
        response.setHeader(METHODS_NAME, "GET, OPTIONS, POST, PUT, DELETE");
        return true;
    }
}

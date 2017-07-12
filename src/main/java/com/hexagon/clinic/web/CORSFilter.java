package com.hexagon.clinic.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CORSFilter implements Filter {

    public CORSFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse r = (HttpServletResponse) response;

        r.addHeader("Access-Control-Allow-Origin", "*");
        r.addHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        r.addHeader("Access-Control-Max-Age", "3600");
        r.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Content-Length, X-Requested-With");

        chain.doFilter(request, response);
    }
}

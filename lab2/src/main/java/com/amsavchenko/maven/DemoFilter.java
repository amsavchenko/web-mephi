package com.amsavchenko.maven;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/DemoFilter")
public class DemoFilter implements Filter {

    private SingltoneSet setId;

    public void init(FilterConfig config) throws ServletException {
        setId = SingltoneSet.getInstance();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        //chain.doFilter(request, response); //request forward to target of request
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        Cookie[] cookies = request.getCookies();
        if (!(cookies == null)){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    if (setId.containsSessionId(cookie.getValue())) {
                        //response.sendRedirect(((HttpServletRequest) req).getContextPath() + "/hello_inside.jsp");
                        request.getRequestDispatcher("hello_inside.jsp").forward(request, response);
                    }
                }
            }
        }

        //else -
        chain.doFilter(request, response); //request forward to target of request
        //response.sendRedirect("http://localhost:8080/lab2_war_exploded/DemoServlet");


    }



}

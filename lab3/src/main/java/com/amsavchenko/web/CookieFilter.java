package com.amsavchenko.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.amsavchenko.web.dao.*;


@WebFilter("/CookieFilter")
public class CookieFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        Cookie[] cookies = request.getCookies();
        if (!(cookies == null)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    String sessionId = cookie.getValue();
                    DAOLoginHash daoLHash = new DAOLoginHash();
                    if (request.getMethod().equalsIgnoreCase("GET")) {
                        boolean isRegistered = daoLHash.isHashContainInTable(sessionId);
                        if (isRegistered)
                            request.getRequestDispatcher("registered_users.jsp").forward(request, response);
                    }
                    else { // method == "POST"
                        String login = (String) request.getParameter("login");
                        boolean isValid = daoLHash.isContainLoginHash(login, sessionId);
                        if (isValid)
                            request.getRequestDispatcher("registered_users.jsp").forward(request, response);
                    }
                }
            }
        }

        //TODO вставить проверку --- если вошел - то невозможно увидеть join и login
        // при get запросе если стоят валидные куки - перенаправление на registered.jsp
        /*
        if (request.getMethod().equalsIgnoreCase("GET")) {
            //DAOLoginHash daoLHash = new DAOLoginHash();
            //isRegistered = daoLHash.isHashContainInTable()
        }

        if (request.getMethod().equalsIgnoreCase("POST")) {

            String login = (String) request.getParameter("login");
            Cookie[] cookies = request.getCookies();
            if (!(cookies == null)) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("sessionId")) {

                        String sessionId = cookie.getValue();

                        //TOD смотрим наличие пары
                        // login-sessionId
                        // в БД 2
                        DAOLoginHash daoLHash = new DAOLoginHash();
                        boolean isValid = daoLHash.isContainLoginHash(login, sessionId);

                        if (isValid)
                            request.getRequestDispatcher("registered_users.jsp").forward(request, response);
                    }
                }
            }
            // если нет валидных cookie - запрос идет дальше, не трогаем
        }
        */
        //TOD возможно здесь должно быть еще одно условие защищающее от прямого захода на registered_users.jsp
        if (request.getRequestURI().equals("/lab3_war_exploded/registered_users.jsp"))
            response.sendRedirect(request.getContextPath() + "/");
            //request.getRequestDispatcher("welcome.jsp").forward(request, response);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

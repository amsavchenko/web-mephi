package com.amsavchenko.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/CookieFilter")
public class CookieFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //TODO вставить проверку --- если вошел - то невозможно увидеть join и login

        if (request.getMethod().equalsIgnoreCase("POST")) {

            String login = (String) request.getParameter("login");
            Cookie[] cookies = request.getCookies();
            if (!(cookies == null)) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("sessionId")) {

                        String sessionId = cookie.getValue();

                        //TODO смотрим наличие пары
                        // login-sessionId
                        // в БД 1

                        boolean loginSessionIdValid = true;
                        if (loginSessionIdValid)
                            request.getRequestDispatcher("registered_users.jsp").forward(request, response);
                    }
                }
            }
            // если нет валидных cookie - запрос идет дальше, не трогаем
        }

        //TODO возможно здесь должно быть еще одно условие защищающее от прямого захода на registered_users.jsp
        if (request.getRequestURI().equals("/lab3_war_exploded/registered_users.jsp"))
            response.sendRedirect(request.getContextPath() + "/");
            //request.getRequestDispatcher("welcome.jsp").forward(request, response);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

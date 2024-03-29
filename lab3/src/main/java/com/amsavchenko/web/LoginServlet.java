package com.amsavchenko.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import com.amsavchenko.web.dao.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // в это место попадаем только если у пользователя нет cookies
        // тогда нам надо проверить его login-password в БД
        String login = (String) request.getParameter("login");
        String password = (String) request.getParameter("password");

        //TOD
        // проверка наличия записи login-password в БД 1
        DAOLoginPassword daoLPas = new DAOLoginPassword();
        boolean isContain = daoLPas.isContainLoginPassword(login, password);

        if (isContain) {
            String uuid = UUID.randomUUID().toString();

            //TOD
            // uuid заносится в БД 2 в формате login - uuid
            DAOLoginHash daoLHash = new DAOLoginHash();
            boolean isAdd = daoLHash.addLoginHash(login, uuid);
            if (isAdd) {
                Cookie cookie = new Cookie("sessionId", uuid);
                response.addCookie(cookie);
            }
            request.getRequestDispatcher("registered_users.jsp").forward(request, response);

        }
        else{ // не нашли соответствия в БД - некореектный логин/пароль
            String incorrectLoginPassword = "<br/><h3>Incorrect login and password</h3> <br/>" +
                    "Try again to <a href=\\\"http://localhost:8080/lab3_war_exploded/login\\\"sign in><br/>" +
                    "New user?  <a href=\\\"http://localhost:8080/lab3_war_exploded/join\\\"Sign up>";
            response.getWriter().println(incorrectLoginPassword);
        }

    }

}

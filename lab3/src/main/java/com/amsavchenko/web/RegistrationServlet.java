package com.amsavchenko.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.amsavchenko.web.dao.DAOLoginPassword;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("join.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = (String) request.getParameter("login");
        String password = (String) request.getParameter("password");

        //TOD
        // проверка в БД на уникальность логина
        // и сохранение в БД 1

        DAOLoginPassword dao = new DAOLoginPassword();
        boolean isOk = dao.addLoginPassword(login, password);

        if (!isOk){
            String answerLoginBusy = "<br/><h3>This login is busy</h3> <br/>" +
                    "Go back to the <a href=\\\"http://localhost:8080/lab3_war_exploded/join\\\"sign up page>" +
                    " to choose another";
            response.getWriter().println(answerLoginBusy);
        }

        // всё норм - перенаправить на LoginServlet
        // else >>>
        response.sendRedirect("login");

    }

}

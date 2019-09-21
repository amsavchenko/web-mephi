package com.amsavchenko.maven;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.Random;


@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {

    private HashMap<Integer, Set<String>> storage;
    private SingltoneSet setId;


    public void init() throws ServletException {
        storage = new HashMap<Integer, Set<String>>();
        setId = SingltoneSet.getInstance();
    }


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Random random = new Random();
        int num1 = -125 + random.nextInt(347 - 125 + 1);;
        int num2 = -125 + random.nextInt(347 - 125 + 1);;
        int sum =  num1 + num2;

        String hash = Integer.toString( Integer.toString(sum).hashCode()) + System.currentTimeMillis();
        if (storage.containsKey(sum))
            storage.get(sum).add(hash);
        else {
            Set<String> set = new HashSet<String>();
            set.add(hash);
            storage.put(sum, set);
        }

        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("hash", hash);

        String message = request.getParameter("message");
        if (message != null) {
            request.setAttribute("message", message);
        }

        request.getRequestDispatcher("count_to_get_in.jsp").forward(request, response);

    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int answer = Integer.parseInt(request.getParameter("answer"));
        String gottenHash = request.getParameter("hash");
        if (storage.containsKey(answer)) {
            if (storage.get(answer).contains(gottenHash)) {
                String uuid = UUID.randomUUID().toString();
                setId.addSessionId(uuid);
                Cookie cookie = new Cookie("sessionId", uuid);
                response.addCookie(cookie);
                request.getRequestDispatcher("hello_inside.jsp").forward(request, response);
            }
        }
            //

        else
            //response.getWriter().write("You're robot. Go out!");
            //request.getRequestDispatcher("http://localhost:8080/lab2_war_exploded/").forward(request, response);
            response.sendRedirect("http://localhost:8080/lab2_war_exploded/");


    }

}

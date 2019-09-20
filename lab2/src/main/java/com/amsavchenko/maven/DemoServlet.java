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


@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {

    private HashMap<Integer, Set<String>> storage;
    private SingltoneSet setId;


    public void init() throws ServletException {
        storage = new HashMap<Integer, Set<String>>();
        setId = SingltoneSet.getInstance();
    }


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int num1 = 7;
        int num2 = 10;
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
                request.getRequestDispatcher("hello_inside.jsp").include(request, response);
            }
        }
            //

        else
            response.getWriter().write("You're robot. Go out!");


    }

}

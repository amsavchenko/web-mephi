package com.amsavchenko.maven;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;



@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {

    private HashMap<Integer, String> storage;

    
    public void init() throws ServletException {
        storage = new HashMap<Integer, String>();
    }


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int num1 = 7;
        int num2 = 10;
        int sum =  num1 + num2;
        String hash = Integer.toString( Integer.toString(sum).hashCode()) + System.currentTimeMillis();

        storage.put(sum, hash);

        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("hash", hash);
        request.getRequestDispatcher("count_to_get_in.jsp").forward(request, response);

    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int answer = Integer.parseInt(request.getParameter("answer"));
        String gottenHash = request.getParameter("hash");
        if (storage.containsKey(answer) && storage.get(answer).equals(gottenHash))
            request.getRequestDispatcher("hello_inside.jsp").include(request, response);
        else
            response.getWriter().write("You're robot. Go out!");


    }

}

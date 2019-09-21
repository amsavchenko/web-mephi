<%@ page import="com.amsavchenko.maven.SingltoneSet" %><%--
  Created by IntelliJ IDEA.
  User: amsavchenko
  Date: 20/09/2019
  Time: 00:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<%
    SingltoneSet setId = SingltoneSet.getInstance();
    Cookie[] cookies = request.getCookies();
    if (cookies == null) {
        //request.getRequestDispatcher("/DemoServlet").forward(request, response);
        response.sendRedirect("http://localhost:8080/lab2_war_exploded/");
    }
    else {
        boolean enableToAccess = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("sessionId")) {
                if (setId.containsSessionId(cookie.getValue())) {
                    enableToAccess = true;
                }
            }
        }
        if (!enableToAccess)
            //request.getRequestDispatcher("/DemoServlet").forward(request, response);
            response.sendRedirect("http://localhost:8080/lab2_war_exploded/");
    }
%>
<head>
    <meta charset="UTF-8">
    <title>Nice to see you</title>
</head>
<body>
<h3>Hello inside</h3>
<p>You're good with captcha. Welcome on board!</p>
</body>
</html>

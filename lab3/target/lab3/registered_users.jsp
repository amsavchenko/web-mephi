<%@ page import="com.amsavchenko.web.dao.DAOLoginPassword" %>
<%@ page import="java.util.List" %>
<%@ page import="com.amsavchenko.web.entities.LoginPassword" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of registered users</title>
</head>
<body>

<br/>
<h2>List of registered users</h2>
<br/>
<p>
    <%
        DAOLoginPassword dao = new DAOLoginPassword();
        List<LoginPassword> lps = dao.findAll();

        for (LoginPassword lp : lps) {
            out.println(lp);
            out.println("<br/>");
        }
    %>
</p>
<p></p>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lenovo pc
  Date: 2019/01/11
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    /*Cookie cookie1 = new Cookie("havij", "sajad");
    Cookie cookie2 = new Cookie("address","tehran");

    response.addCookie(cookie1);
    response.addCookie(cookie2);
    out.print("mersi");*/

    session.setAttribute("x", "xxx");
    request.getSession().setAttribute("y", "yyy");
    response.sendRedirect("get.jsp");

%>

</body>
</html>

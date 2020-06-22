<%--
  Created by IntelliJ IDEA.
  User: lenovo pc
  Date: 2019/01/12
  Time: 01:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    response.sendRedirect("two.jsp");
    response.sendError(404); // sakht error

%>

</body>
</html>

<%@ page import="tehran.Sajad" %><%--
  Created by IntelliJ IDEA.
  User: lenovo pc
  Date: 2019/01/11
  Time: 05:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%

      Sajad sajad = new Sajad();
      sajad.one(out);
      out.print(sajad.two());

      String n = request.getParameter("name");
      out.print(n);


  %>


  </body>
</html>

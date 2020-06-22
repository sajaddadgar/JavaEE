<%@ page import="tehran.PersonDA" %>
<%@ page import="tehran.Person" %><%--
  Created by IntelliJ IDEA.
  User: lenovo pc
  Date: 2019/01/11
  Time: 09:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    PersonDA personDA = new PersonDA();
    Person person = new Person(request.getParameter("name"), request.getParameter("family"));
    personDA.insert(person);
    personDA.close();
    response.sendRedirect("/one.jsp ");

%>

</body>
</html>

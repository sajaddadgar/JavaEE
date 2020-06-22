<%@ page import="tehran.PersonDA" %>
<%@ page import="tehran.Person" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo pc
  Date: 2019/01/11
  Time: 05:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>information</title>
</head>
<body>

    <table border="1" width="100%">
        <tr>
            <td>name</td>
            <td>family</td>
        </tr>

        <%

            PersonDA personDA = new PersonDA();
            List<Person> personList = personDA.select();
            for (Person person1 : personList) {

        %>

        <tr>
            <td><%=person1.getName()%></td>
            <td><%=person1.getFamily()%></td>
        </tr>

        <%
            }
            personDA.close();
        %>

    </table>

</body>
</html>

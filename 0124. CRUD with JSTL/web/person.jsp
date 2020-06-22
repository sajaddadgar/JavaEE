<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.Person" %>
<%--
  Created by IntelliJ IDEA.
  User: Bahador
  Date: 10/19/2018
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="register.do">
    <input type="text" name="name"/>
    <br/>
    <input type="text" name="family"/>
    <br/>
    <input type="submit" value="register"/>
    <br/>
</form>
<table border="1" style="width: 100%">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>FAMILY</td>
        <td>OPER</td>
        <td>OPER</td>
    </tr>



    <c:forEach items="${requestScope.personList}" var="p">




    <tr>
        <form action="/change.do">
            <td><input type="text" name="id" id="pid" readonly value="${p.id}"></td>
            <td><input type="text" name="name" value="${p.name}"></td>
            <td><input type="text" name="family" value="${p.family}"></td>
            <td><input type="submit" value="change"></td>
            <td><input type="button" value="remove" onclick="removePerson(${p.id})"></td>
        </form>
    </tr>
    </c:forEach>

    <script>
        function removePerson(id) {


            if (confirm('r u sure?'))
                window.location = 'remove.do?id=' + id;

        }
    </script>
</table>
</body>
</html>

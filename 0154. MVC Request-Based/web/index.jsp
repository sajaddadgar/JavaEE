<%@ page import="java.util.Locale" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AmirBahador
  Date: 12/14/2018
  Time: 1:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    Locale.setDefault(Locale.ENGLISH);
%>
<script>
    function removePersonRow(id) {
        if (confirm('are you sure?'))
            window.location = "/person/remove?id=" + id;
    }
    function removeCarRow(id) {
        if (confirm('are you sure?'))
            window.location = "/car/remove?id=" + id;
    }
</script>
<form action="/person/register">
    <input type="text" name="name"/>
    <input type="text" name="family"/>
    <input type="text" name="model"/>
    <input type="submit"/>
</form>
<table border="1" style="width:100%;">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>FAMILY</td>
        <td>UPDATE</td>
        <td>DELETE</td>
        <td>CAR</td>
    </tr>
    <c:forEach items="${requestScope.list}" var="p">
        <tr>
            <form action="/person/change">
                <td><input type="text" name="id" value="${p.id}" style="width: 100%" readonly/></td>
                <td><input type="text" name="name" value="${p.name}" style="width: 100%"/></td>
                <td><input type="text" name="family" value="${p.family}" style="width: 100%"/></td>
                <td><input type="submit" value="UPDATE"/></td>
                <td><input type="button" value="DELETE" onclick="removePersonRow(${p.id})"/></td>
            </form>
            <td>
                <table border="1" style="width:100%;">
                    <tr>
                        <td>ID</td>
                        <td>MODEL</td>
                        <td>UPDATE</td>
                        <td>DELETE</td>
                    </tr>
                    <tr>
                        <form action="/car/register">
                            <input type="hidden" name="personId" value="${p.id}"/>
                            <td><input type="text" name="model"/></td>
                            <td><input type="submit" value="ADD"/></td>
                        </form>
                    </tr>
                    <c:forEach items="${p.carList}" var="c">
                        <form action="/car/change">
                            <tr>
                                <td><input type="text" name="id" readonly value="${c.id}"/></td>
                                <td><input type="text" name="model" value="${c.model}"/></td>
                                <td><input type="submit" value="UPDATE"/></td>
                                <td><input type="button" value="DELETE" onclick="removeCarRow(${c.id})"/></td>
                            </tr>
                        </form>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
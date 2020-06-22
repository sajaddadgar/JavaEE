<%@ page import="java.util.List" %>
<%@ page import="model.entity.Person" %><%--
  Created by IntelliJ IDEA.
  User: lenovo pc
  Date: 2019/01/13
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/register.do">

        <input type="text" name="name"/>
        <input type="text" name="family"/>
        <input type="submit" value="register"/>

    </form>


    <table border="1" width="100%">

        <tr>
            <td>id</td>
            <td>name</td>
            <td>family</td>
            <td>oper</td>
            <td>oper</td>
        </tr>

        <%

            List<Person> personList = (List<Person>) request.getAttribute("personList");
            for (Person person : personList) {

        %>

        <tr>

            <form action="/change.do">

                <td><input type="text" name="id" readonly value="<%=person.getId()%>"/></td>
                <td><input type="text" name="name" value="<%=person.getName()%>"/></td>
                <td><input type="text" name="family" value="<%=person.getFamily()%>"/></td>
                <td><input type="submit" value="change"/></td>
                <td><input type="button" value="remove" onclick="removePerson(<%=person.getId()%>)"/></td>

            </form>

        </tr>

        <%
            }
        %>
        <script>

            function removePerson(id) {

                if (confirm('r u sure???')) {
                    window.location = 'remove.do?id='+id
                }

            }

        </script>


    </table>

</body>
</html>

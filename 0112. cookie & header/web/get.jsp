<%@ page import="java.util.Enumeration" %><%--
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
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            out.print(cookie.getName() + " " + cookie.getValue() + "</br>");
        }
    %>

<p>--------------------------------------<br></p>

<%

    Enumeration<String> stringEnumeration = request.getHeaderNames();
    while (stringEnumeration.hasMoreElements()){
        String headerName = stringEnumeration.nextElement();
        out.print(headerName + " " + request.getHeader(headerName)+"<br/><br/><br/>");
    }

    out.print(request.getRemoteAddr());
    out.print(request.getHeader("referer"));

%>

    <p>--------------------------------------<br></p>

<%
    out.print(request.getSession().getAttribute("x"));
    out.print(request.getSession().getAttribute("y"));
%>

</body>
</html>

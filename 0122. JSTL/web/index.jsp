<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo pc
  Date: 2019/01/13
  Time: 02:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <c:out value="salam"/> <%--out.print("salam")--%>
  <c:out value="${2+2}"/> <%--print: 4--%>
  ${2+2} <%--print: 4--%>

  ${requestScope.name} <%--request.getAttribute("name")--%>
  ${sessionScope.name} <%--request.getSession().getAttribure("name")--%>
  ${param.name} <%--request.getParameter("name")--%>

  <c:if test="${param.name == 'jamal'}"> <%--if(request.getParameter("name") == "jamal")--%>
    <p>haha</p>
  </c:if>

  <c:choose> <%--switch case--%>
    <c:when test="${2+2}">

    </c:when>

    <c:when test="${2==3}">

    </c:when>

    <c:otherwise>

    </c:otherwise>
  </c:choose>

  <c:forEach items="${requestScope.list}" var="p"> <%--foreach--%>

    ${p.name}

  </c:forEach>


  <c:forEach begin="1" end="100" step="1" var="i"> <%--for--%>
    ${i}
  </c:forEach>


  </body>
</html>

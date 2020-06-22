<%--
  Created by IntelliJ IDEA.
  User: lenovo pc
  Date: 2019/01/12
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%

        request.setAttribute("sajad", "dadgar"); // be shart dispatch mishe az an dar safhe baad az on estefade kard.
        System.out.println(request.getParameter("name"));
        /*response.sendRedirect("/WEB-INF/x.jsp");*/
        request.getRequestDispatcher("/WEB-INF/x.jsp").forward(request, response);



    %>

</body>
</html>

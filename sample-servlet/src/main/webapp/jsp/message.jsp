<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/10 0010
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mseeage</title>
</head>
<body>

    ${data}

    <%
        String data = (String) request.getAttribute("data");
        out.write(data);
    %>

    <%
        String message = (String) application.getAttribute("message");
        out.write(message);
    %>

</body>
</html>

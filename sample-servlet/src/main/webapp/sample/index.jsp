<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/25 0025
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>首页</title>
</head>
<body style="text-align: center">

<h2>xxxx网站</h2>
<br/>
<br/>
<div>
    <c:if test="${user!=null}">
        欢迎您: ${user.username} <a href="/sample/LogoutServlet">注销</a>
    </c:if>
    <c:if test="${user==null}">
        <a href="RegisterUIServlet">注册</a>
        <a href="/sample/LoginUIServlet">登录</a>
    </c:if>
</div>
<hr/>
</body>
</html>

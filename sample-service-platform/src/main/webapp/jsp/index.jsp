<%@ page language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>index</title>
</head>
<body>
    欢迎您: ${user.username}<br/>
    <a href="/html/login.html">登录</a><br/>
    <a href="/LogoutServlet">退出登录</a><br/><br/>
    <a href="/SessionDemo1">购买</a><br/>
    <a href="/SessionDemo2">结账</a><br/>
</body>
</html>

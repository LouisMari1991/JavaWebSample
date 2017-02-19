<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>form3</title>

</head>
<body>

<form action="/DoFromServlet" method="post">
    <input type="hidden" name="token" value="${token}"/>
    用户名：<input type="text" name="username"/>
    <input type="submit" value="提交"/>
</form>

</body>
</html>
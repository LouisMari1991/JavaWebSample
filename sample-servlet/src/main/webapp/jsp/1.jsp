<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: YH
  Date: 2017-02-19
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
当前时间值是:
<%
    Date date = new Date();
    String time = date.toLocaleString();
    /*out.write(date.toLocaleString());*/
%>

<%=time %> <!-- 脚本表达式，它的作用就是用于向浏览器输出数据 -->

</body>
</html>

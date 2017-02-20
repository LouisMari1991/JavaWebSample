<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/20 0020
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp:usebean</title>
</head>
<body>
<%-- userbean 标签体只在userbean实例化时执行--%>
<jsp:useBean id="person" class="com.sync.sz.web.servlet.domain.Person" scope="session">
    bbbbb
</jsp:useBean>
<%= person.getName()%>
</body>
</html>

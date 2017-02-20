<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/20 0020
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp:setProperty标签</title>
</head>
<body>

<jsp:useBean id="person" class="com.sync.sz.web.servlet.domain.Person"/>

<%--手工为bean属性赋值--%>
<jsp:setProperty name="person" property="name" value="xxxxx"/>

<%= person.getName()%><br/>

<%--用请求参数给bean的属性赋值--%>
<%-- http://localhost:8081/javabean/2.jsp?name=uuuuuuuuuuuuuuu&age=12 --%>
<jsp:setProperty name="person" property="name" param="name"/>
<jsp:setProperty name="person" property="age" param="age"/>
<%--请求参数支持8种基本数据类型转换(把客户机提交的字符串，转成8种基本类型，赋值到bean属性上)--%>
<jsp:setProperty name="person" property="birthday" value="<%= new Date()%>"/>
<%= person.getName()%><br/>
<%= person.getAge()%><br/>
<%= person.getBirthday()%><br/>

<br/>---------------------------------------------------------<br/>

<%-- 用所有的请求参数为bean赋值 --%>
<jsp:setProperty name="person" property="*"/>
<%= person.getName()%><br/>
<%= person.getAge()%><br/>

<br/>---------------------------------------------------------<br/>

<jsp:getProperty name="person" property="name"/><br/>
<jsp:getProperty name="person" property="age"/><br/>
<jsp:getProperty name="person" property="birthday"/><br/>
<jsp:getProperty name="person" property="class"/><br/>

</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sync.sz.web.servlet.domain.Person" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/24 0024
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用jstl+el完成集合迭代</title>
</head>
<body>

<%
    List list = new ArrayList();
    list.add(new Person("aaa"));
    list.add(new Person("bbb"));
    list.add(new Person("ccc"));

    request.setAttribute("list", list);
%>

<c:forEach items="${list}" var="person">
    ${person.name}<br/>
</c:forEach>

<%
    Map map = new HashMap();
    map.put("aa", new Person("aa"));
    map.put("bb", new Person("bb"));
    map.put("cc", new Person("cc"));
    map.put("dd", new Person("dd"));

    request.setAttribute("map", map);
%>


<c:forEach items="${map}" var="entry">
    ${entry.key} : ${entry.value} <br/>
</c:forEach>
<br/>
<c:forEach items="${map}" var="entry">
    ${entry.key} : ${entry.value.name} <br/>
</c:forEach>

<br/>

<%--代表用户登录--%>
<c:if test="${user!=null}">
    欢迎您: ${user.username}
</c:if>

<%--代表用户没登陆--%>
<C:if test="${user==null}">
    用户名:<input type="text"/>
    密码:<input type="text"/>
</C:if>


</body>
</html>

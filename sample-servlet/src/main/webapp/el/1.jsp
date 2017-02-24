<%@ page import="com.sync.sz.web.servlet.domain.Person" %>
<%@ page import="com.sync.sz.web.servlet.domain.Address" %>
<%@ page import="java.util.*" %>
<%--
Created by IntelliJ IDEA.
User: Administrator
Date: 2017/2/23 0023
Time: 21:24
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式</title>
</head>
<body>

<%
    String data = "abcd";
    request.setAttribute("data", data);

%>

${data} <%-- pageContext.findAttribute("data") page request session application --%>
<br/>


<%
    Person p = new Person();
    p.setName("aaa");

    request.setAttribute("person", p);
%>

${person.name}
<br/>

<%
    Person p1 = new Person();
    Address a = new Address();
    a.setCity("深圳");
    p1.setAddress(a);

    request.setAttribute("p1", p1);
%>

${p1.address.city}
<br/>

<%
    List list = new ArrayList();
    list.add(new Person("aaa"));
    list.add(new Person("bbb"));
    list.add(new Person("ccc"));

    request.setAttribute("list", list);
%>

${list[1].name}
<br/>


<%
    Map map = new HashMap();
    map.put("aa", new Person("aa"));
    map.put("bb", new Person("bb"));
    map.put("cc", new Person("cc"));
    map.put("dd", new Person("dd"));

    request.setAttribute("map", map);
%>

${map.bb.name}
<br/>
${map['dd'].name}<%-- 用el表达式去数据的时候，通常用 . 号， . 号取不出来时，用 [] 号 --%>
<br/>

${pageContext.request.contextPath} <%-- getRequest --%>

<br/>

<%=request.getContextPath()%>

</body>
</html>

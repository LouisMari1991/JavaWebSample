<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/21 0021
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计算器</title>
    <style>

        body {
            margin: 0px;
            padding: 0px;
            font-size: 14px;
            overflow: hidden;
            text-align: center;
        }

        #container {
            margin: auto;
        }


    </style>
</head>
<body style="text-align: center">

<jsp:useBean id="calculatorBean" class="com.sync.sz.web.servlet.calc.CalculatorBean"/>
<jsp:setProperty name="calculatorBean" property="*"/>

<%
    try {
        calculatorBean.calculator();
    } catch (Exception e) {
        out.write(e.getMessage());
    }
%>

<div id="container">

    <br/>------------------------------------------------<br/>
    计算结果是:
    <jsp:getProperty name="calculatorBean" property="firstNum"/>
    <jsp:getProperty name="calculatorBean" property="operator"/>
    <jsp:getProperty name="calculatorBean" property="secondNum"/>

    =

    <jsp:getProperty name="calculatorBean" property="result"/>

    <br/>------------------------------------------------<br/>


    <form method="post" action="/calc/calculator.jsp">
        <table width="40%" border="1">
            <tr>
                <td colspan="2">简单计算器</td>
            </tr>
            <tr>
                <td>第一个参数</td>
                <td>
                    <input type="text" name="firstNum"/>
                </td>
            </tr>
            <tr>
                <td>操作符</td>
                <td>
                    <select name="operator">
                        <option value="+">+</option>
                        <option value="-">-</option>
                        <option value="*">*</option>
                        <option value="/">/</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>第二个参数</td>
                <td>
                    <input type="text" name="secondNum"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="计算">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

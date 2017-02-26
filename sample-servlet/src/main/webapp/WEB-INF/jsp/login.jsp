<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/26 0026
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <style>
        body {
            margin: 0px;
            padding: 0px;
            font-size: 14px;
            background-color: #016aa9;
            overflow: hidden;
            text-align: center;
        }

        #container {
            margin: auto;
            width: 980px;
        }

        #login {
            width: 925px;
            height: 353px;
        }

        #form {
            margin-top: 180px;
        }

        #input div {
            margin-bottom: 5px;
        }

        #input input {
            color: #6cd0ff;
            width: 120px;
            height: 14px;
            background-color: #292929;
            border: 0px;
        }

        #btn {
            margin-left: 20px;
            margin-top: 10px;
        }

        #btn input {
            cursor: pointer;
            width: 49px;
            margin-left: 8px;
            height: 18px;
        }

    </style>

    <meta charset="UTF-8">
    <title>用户登录</title>
</head>
<body>

<form method="post" action="/sample/LoginServlet">
    <div id="container">

        <div id="login">
            <div id="form">
                <form>
                    <div id="input">
                        <div>用户:<input type="text" name="username"/><br/></div>
                        <div> 密码:<input type="password" name="password"/><br/></div>
                    </div>
                    <div id="btn">
                        <input type="submit" value="登录"/>
                    </div>
                </form>
            </div>
        </div>


    </div>
</form>
</body>
</html>

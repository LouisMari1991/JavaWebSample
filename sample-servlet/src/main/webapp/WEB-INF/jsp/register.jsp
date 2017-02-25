<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/25 0025
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
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

</head>
<body>
<div id="container">
    <div id="login">
        <div id="form">
            <form method="post" action="/sample/RegisterServlet">
                <div id="input">
                    <div>登录帐号:<input type="text" name="username"/><br/></div>
                    <div> 登录密码:<input type="password" name="password"/><br/></div>
                    <div> 确认密码:<input type="password" name="checkPassword"/><br/></div>
                    <div>电子邮箱:<input type="email" name="email"/><br/></div>
                    <div>生日:<input type="date" name="birthday"/><br/></div>
                    <div>您的昵称:<input type="text" name="nickname"/><br/></div>
                    <div>图片认证:<input type="text" name="img"/><br/></div>
                </div>
                <div id="btn">
                    <input type="reset" name="reset" value="重置"/>
                    <input type="submit" value="注册"/>
                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>

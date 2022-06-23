<%--
  Created by IntelliJ IDEA.
  User: dade
  Date: 2022/6/23
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    * {
        margin: 0;
        padding: 0;
    }
    html {
        height: 100%;
        width: 100%;
        overflow: hidden;
        margin: 0;
        padding: 0;
        background: url("32.jpg") no-repeat;
        background-size: 100% 100%;
    }
    body {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100%;
    }
    #center {
        width:25%;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 50%;
        background-color: rgba(250, 249, 246, 0.479);
        border-radius: 50%;
    }
    p {
        margin-top: 30px;
        margin-left: 20px;
        color: rgb(51, 59, 59);
    }
    input {
        margin-left: 15px;
        border-radius: 5px;
        border-style: hidden;
        height: 30px;
        width: 140px;
        background-color: rgba(119, 173, 209, 0.5);
        outline: none;
        color: #ffffff;
        padding-left: 10px;
    }
    button {
        border-color: cornsilk;
        background-color: rgba(100, 149, 237, .7);
        color: aliceblue;
        border-style: hidden;
        border-radius: 5px;
        width: 100px;
        height: 31px;
        font-size: 16px;
    }


</style>
<head>
    <title>后台登陆入口</title>
</head>
<body>
<div id="center">
    <form method="post" action="LoginServlet" name="login">
        <h1 style="text-align: center;color:rgba(56, 55, 52, 0.788)">登录</h1></br>
        <p>账号：<input type="text" name="username" placeholder="请输入账号"> </p>
        <p>密码：<input type="password" name="password" placeholder="请输入密码">  </p>
        <div style="text-align: center;margin-top: 30px;">
            <input type="submit" class="button"  value="登陆">
        </div>
    </form>
</div>
<script language="javascript" type="text/javascript">

</script>
</body>
</html>

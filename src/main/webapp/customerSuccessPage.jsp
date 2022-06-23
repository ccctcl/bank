<%@ page import="com.example.bank.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: dade
  Date: 2022/6/23
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
        #center{
            width: 1000px;
            height: 400px;
            line-height: 100px;
            text-align: center;
            background-color: rgba(250, 246, 246, 0.728);
        }
        h1{
            text-align: center;
            color: rgb(51, 59, 59);
        }
    </style>
    <title>登陆成功界面</title>
</head>
<body>
<% User user=(User) request.getAttribute("user");
    if (user==null){
        request.getRequestDispatcher("failLogin.jsp");
    }
%>
<div>
    <div id="center">
        <p><h1>欢迎您，<%=user.getName()%></h1></p>

        <div class="img-box">
            <h1><span id="second"></span></h1>
        </div>

        <a href="customerViewServlet">点我立即跳转</a>
    </div>
</div>
<script language="javascript" type="text/javascript">
    var time = 5;
    function Redirect() {
        window.location = "customerViewServlet";
    }
    var i = 0;
    function Replay() {
        document.getElementById("second").innerHTML= "将在" + (time - i) + "秒后跳转到展示界面";
        i++;
    }
    timer = setInterval('Replay()', 1000); //显示时间
    timer = setTimeout('Redirect()', time * 1000);
</script>
</body>
</html>

<%@ page import="com.example.bank.domain.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dade
  Date: 2022/6/21
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        *{
            margin: 0;
            padding: 0;
            border: 0;
            list-style: none;
            text-decoration: none;
            font-size: 14px;
        }
        body{
            background: url(32.jpg) no-repeat;
            background-size: 100% 100%;
        }
        .nav{
            width: 100%;
            height: 50px;
            background-color: #75caf583;
            margin: 9px 0px 0px 0px ;
            line-height: 50px;
            text-align: left;
        }
        .nav_con{
            width: 1000px;
            margin: 0px auto;
            padding: 0px;
        }
        .nav ul{
            width: 1000px;
            margin: 0px 0px 0px 15px;
            padding: 0px;

        }
        .nav ul li a{
            float: left;
            color: #fff;
            font-size: 16px;
            font-weight: bold;
            padding: 0px 80px;
        }

        .nav ul .cur span{
            display: block;
            padding: 3px;
        }
        .nav ul li a:hover{
            background-color: rgba(255, 255, 255, 0.479);
            height: 50px;
            margin: -3px;

        }
        .nav ul li span{
            display: block;
            padding: 3px;
        }
        .banner{
            width: 1000px;
            height: 285px;
            margin: 13px auto 15px auto;
            position: relative;
            overflow: hidden;
        }
        .biaoge{
            display: inline-block;
            background:rgba(255, 255, 255, 0.592);
            width: 1000px;
        }
        .biaoge table{
            border: 1px solid #000000;
        }
        .biaoge table tr th{
            width: 250px;
            border: 1px solid #000000;
        }.biaoge table tr td{
             width: 250px;
             border: 1px solid #000000;
             text-align: center;
         }

        .content{
            margin: 15px auto 0px auto;
            padding-bottom:15px;
            width: 1000px;
            height: 480px;

        }
        .line1{
            margin: 0;
            padding: 0;
            position: relative;
            overflow: hidden;
        }
        .line1 .left{
            float: left;
            margin: 0;
            padding: 0;
            width: 330px;
            height: 230px;
            overflow: hidden;

        }
        .add_title{
            width: 330px;
            height: 30px;
            line-height: 30px;
            text-align: center;
            border: 1px solid #d6d6d6;
            border-bottom: 1px solid #808080;
            background-color: rgba(255, 255, 255, 0.479);
            font-weight: bold;
        }
        .add_con{
            width: 330px;
            height: 150px;
            background-color: rgba(255, 255, 255, 0.479);
        }
        .add_con table{
            padding-left: 50px;
        }

        #add{
            margin:20px 150px ;

        }

        .center{
            width: 330px;
            height: 180px;
            float: left;
            margin: 0px 15px;
            background-color: rgba(255, 255, 255, 0.479);
        }
        .select_title{
            line-height: 30px;
            border: 1px solid #ffffffb5;
            border-bottom: 1px solid #808080;
            font-weight: bold;
            text-align: center;
        }
        #select{
            margin:20px 100px ;
        }
        .select_con{
            padding-left: 50px;
        }
        .right{
            margin: 0px;
            padding: 0px;
            width: 310px;
            height: 180px;
            background-color: rgba(255, 255, 255, 0.479);
            float: right;
            overflow: hidden;
        }
        .update_title{
            width: 330px;
            height: 30px;
            line-height: 30px;
            text-align: center;
            border: 1px solid #d6d6d6;
            border-bottom: 1px solid #808080;
            background-color: rgba(255, 255, 255, 0.479);
            font-weight: bold;
        }
        .update_con{
            width: 330px;
            height: 160px;

        }
        .update_con table{
            padding-left: 50px;
        }

        #update{
            margin:20px 150px ;

        }
        .footer{
            width: 100%;
            background-color: #f1ebebcf;
            clear: both;
            padding-bottom: 25px;
            height: 43px;
        }
        .footer_con p{
            line-height: 22px;
            text-align: center;
            color: #909090;
        }
        .line2{
            width: 1000px;
            height: 70px;
            background-color: rgba(255, 255, 255, 0.479);
        }
        .trans_title{
            width: 1000px;
            height: 30px;
            line-height: 30px;
            text-align: center;
            border: 1px solid #d6d6d6;
            border-bottom: 1px solid #808080;
            background-color: rgba(255, 255, 255, 0.479);
            font-weight: bold;
        }
        .trans_con{
            display: inline-block;
            margin: 5px 10px;
        }
        .source{
            float: left;
            margin: 0px 10px;
        }
        .target{
            float: left;
            margin: 0px 35px;
        }
        .money{
            float: left;
            margin: 0px 30px;
        }

    </style>





    <title>展示数据界面</title>
</head>
<body>

<%
    List<Account> list = (List<Account>)  request.getAttribute("list");
%>
<div class="nav">
    <div class="nav">
        <div class="nav_con"><ul>
            <li class="cur"><a href="ViewServlet"><span>首 页</span></a></li>
            <li><a href="#"><span>投资理财</span></a></li>
            <li><a href="#"><span>相关资讯</span></a></li>
            <li><a href="#"><span>账户明细</span></a></li>
        </ul></div>
    </div>
</div>

<div class="banner">
    <div class="biaoge">
        <table border="1px">
            <tr>
                <th>序号</th>
                <th>名称</th>
                <th>ID</th>
                <th>余额</th>
            </tr>
            <%
                String name;
                int id,nameId;
                float money;
                for (Account account:list){
                        id=account.getId();
                        name =account.getName();
                        nameId=account.getNameId();
                        money=account.getMoney();
            %>
            <tr>
                <td><%=id%> </td>
                <td><%=name%></td>
                <td><%=nameId%></td>
                <td><%=money%></td>
            </tr>
            <%}%>

        </table>
    </div>
</div>

<div class="content">

    <div class="line1">

        <div class="left">

            <div class="add">
                <div class="add_title">增加</div>
                <div class="add_con">
                    <form method="post" name="operate" action="OperationServlet?action=add">
                        <table>
                            <tr>
                                <th>名称</th>
                                <td><input type="text" name="name"></td>
                            </tr>
                            <tr>
                                <th>ID</th>
                                <td><input type="text" name="nameId"></td>
                            </tr>
                            <tr>
                                <th>余额</th>
                                <td><input type="text" name="money"></td>
                            </tr>
                        </table>
                        <input placeholder="添加" type="submit" value="增加" id="add">
                    </form>
                </div>
            </div>

        </div>

        <div class="center">
            <div class="select">
                <div class="select_title">查询</div>
                <div class="select_con">
                    <form method="post" name="operate" action="OperationServlet?action=select" >
                        <select name="choice">
                            <option value="id">序号:</option>
                            <option value="nameId">ID:</option>
                        </select>
                        <input type="text" name="input">
                        <input placeholder="查询" type="submit" value="查询" id="select">
                    </form>
                </div>
            </div>

            <div class="delete">
                <div class="select_title">删除</div>
                <div class="select_con">
                    <form method="post" name="operate" action="OperationServlet?action=delete">
                        <table>
                            <tr>
                                <th>序号</th>
                                <td><input type="text" name="id"></td>
                                <td><input placeholder="删除" type="submit" value="删除"></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>

        <div class="right">
            <div class="update">
                <div class="update_title">更新</div>
                <div class="update_con">
                    <form method="post" name="operate" action="OperationServlet?action=update">
                        <table>
                            <tr>
                                <th>序号</th>
                                <td><input type="text" name="id"></td>
                            </tr>
                            <tr>
                                <th>名称</th>
                                <td><input type="text" name="name"></td>
                            </tr>
                            <tr>
                                <th>ID</th>
                                <td><input type="text" name="nameId"></td>
                            </tr>
                            <tr>
                                <th>余额</th>
                                <td><input type="text" name="money"></td>
                            </tr>
                        </table>
                        <input placeholder="更改" type="submit" value="更改" id="update">
                    </form>
                </div>
            </div>

        </div>

    </div>

    <div class="line2">
        <div class="trans">
            <div class="trans_title">转账</div>
            <div class="trans_con">
                <form method="post" name="operate" action="OperationServlet?action=trans" >
                    <div class="source">
                        <span>发起人</span>
                        <select name="choice1">
                            <option value="id">序号:</option>
                            <option value="nameId">ID:</option>
                        </select>
                        <input type="text" name="source">

                    </div>

                    <div class="target">
                        <span>接收人</span>
                        <select name="choice2">
                            <option value="id">序号:</option>
                            <option value="nameId">ID:</option>
                        </select>
                        <input type="text" name="target">
                    </div>

                    <div class="money">
                        <span>金额</span>
                        <input type="text" name="money">
                    </div>

                    <input placeholder="转账" type="submit" value="转账" id="trans">
                </form>
            </div>
        </div>
    </div>

</div>


<div class="footer">
    <div class="footer_con">
        <p>&copy;2022.06.24</p>

    </div>
</div>



</body>
</html>

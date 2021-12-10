<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: 敬亚霖
  Date: 2021/12/8
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改操作</title>
    <style>
        * {
            overflow: hidden;
        }
        body {
            background: url("./img/img_2.png");
            background-size: 100% 100%;

        }
        .form1 {
            width: 400px;
            height: 400px;
            background-color: rgba(255,255,255,0.5);
            margin: 150px auto;
            border-radius: 13px
        }
        .up {
            text-align: center;
            padding-top: 30px;
            padding-bottom: 15px;
            color: gray;
        }
        .number {
            text-align: center;
            width: 200px;
            height: 40px;
            margin-top: 20px;
            margin-bottom: 20px;
            margin-left: 95px;
            border-radius: 13px
        }
        .name {
            text-align: center;
            width: 200px;
            height: 40px;
            margin-top: 20px;
            margin-bottom: 20px;
            margin-left: 95px;
            border-radius: 13px
        }
        .button1 {
            text-align: center;
            width: 200px;
            height: 40px;
            margin-top: 20px;
            margin-bottom: 20px;
            margin-left: 98px;
            border-radius: 13px
        }
    </style>
</head>
<body>
<%
    Student stu=(Student) request.getAttribute("stu");
%>
<form action="update" method="post" class="form1">
    <h2 class="up">修改操作</h2>
    <input type="text" placeholder="输入学号" name="stuno" value="<%=stu.getSno()%>" class="number"><br>
    <input type="text" placeholder="输入姓名" name="stuname" value="<%=stu.getName()%>" class="name"><br>
    <input type="hidden" name="id" value="<%=stu.getId()%>">
    <input type="submit" value="修改" class="button1">
</form>
</body>
</html>

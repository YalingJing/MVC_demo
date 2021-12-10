<%--
  Created by IntelliJ IDEA.
  User: 8613890794742
  Date: 2021/12/8
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
    <style>
        * {
            overflow: hidden;
        }
        body {
            background: url("./img/img_1.png");
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
        }
    </style>
</head>
<body>
<form action="add" method="post" class="form1">
    <h2 class="up">添加操作</h2>
    <input type="text" placeholder="输入学号" name="stuno" class="number"><br>
    <input type="text" placeholder="输入姓名" name="stuname" class="name"><br>
    <input type="submit" value="添加" class="button1">
</form>
</body>
</html>

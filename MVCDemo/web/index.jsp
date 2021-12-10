<%@ page import="entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 8613890794742
  Date: 2021/12/8
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>学生信息</title>
  <style>
    body {
      background: url("./img/img_3.png");
      background-size: 100% 100%;
    }
    .info {
      color: rgba(255,255,255,0.8);
      font-size: 38px;
      text-align: center;
      margin-top: 40px;
      margin-bottom: 40px;
      font-family: 微软雅黑;
    }
    .personal_information table{
      width: 120px;
      height: 30px;
      color: rgba(255,255,255,0.7);
      margin: 40px auto;
    }

    .personal_information table tr td{
      border: 1px solid rgba(255,255,255,0.2);
      text-align: center;
    }

    .personal_information table tr th {
      border: 1px solid rgba(255,255,255,0.2);
      text-align: center;
    }

    .add_info {
      width: 202px;
      height: 40px;
      background-color: steelblue;
      line-height: 40px;
      text-align: center;
      margin-left: 343px;
      border-radius: 5px;
    }

    .add_info a {
      text-decoration: none;
      color: #fcf6ff;
      font-family: 微软雅黑;
      font-weight: 700;
    }

    .stu_info {
      overflow-y: scroll;
    }

    .stu_info table{
      width: 800px;
      border: 1px solid;
      border-collapse:collapse;
      margin: auto;
    }

    td,th{
      border: 1px solid;
      text-align: center;
      color: #fcf6ff;

    }

    .stu_info_1, .stu_info_2 {
      text-decoration: none;
      color: #75aeff;
    }

    .tou {
      background-color: steelblue;
      height: 40px;
    }

    .stu_info table td,th {
      border: 1px solid rgba(255,255,255,0.7);
      text-align: center;
    }

    .stu_info .xia {
      background-color: rgba(255,255,255,0.7);
    }

    .stu_info a {
      color: rgba(42,127,253,0.81);
      font-weight: 700;
      font-style: italic;
    }

    .stu_info .id_1,.name_1 {
      color: dimgrey;
      font-weight: bold;
    }
    .logout a {
      color: #fcf6ff;
      width: 100px;
      height: 20px;
      line-height: 20px;
      text-decoration: none;
      background-color: rgba(255,255,255,0.2);
      font-weight: 700;
    }
    .people_num {
      width: 100px;
      height: 100px;
      color: #fcf6ff;
      float: right;
    }
  </style>
</head>
<body>
<div class="logout"><a href="logout">退出系统</a></div>
<%
  List<String> online = (List<String>) request.getServletContext().getAttribute("online");
%>
<div class="people_num">
  <sapn>当前在线人数：</sapn>
  <span><%=online.size()-1%></span>
</div>
<div class="info">欢迎来到信息管理系统</div>
<%
  User user=(User) request.getSession().getAttribute("user");
%>
<div class="personal_information">
  <table>
    <tr>
      <th colspan="2">个人登陆信息</th>
    </tr>
    <tr>
      <th>用户账号</th>
      <th>用户密码</th>
    </tr>
    <tr>
      <td><%=user.getUsername()%></td>
      <td><%=user.getPassword()%></td>
    </tr>
  </table>
</div>
<div class="add_info">
  <a href="add.jsp">添加</a>
</div>
<div class="stu_info">
  <table>
    <tr class="tou">
      <th>学号</th>
      <th>姓名</th>
      <th>修改</th>
      <th>删除</th>
    </tr>
    <%
      ArrayList<Student> list=(ArrayList<Student>) request.getAttribute("list");
      for (Student stu:list){
    %>
    <tr class="xia">
      <td class="id_1"><%=stu.getSno()%></td>
      <td class="name_1"><%=stu.getName()%></td>
      <td><a href="edit?id=<%=stu.getId()%>" class="stu_info_1">修改</a></td>
      <td><a href="del?id=<%=stu.getId()%>" onclick="return confirm('确认要删除？？')" class="stu_info_2">删除</a></td>
    </tr>
    <%
      }
    %>
  </table>
</div>
</body>
</html>

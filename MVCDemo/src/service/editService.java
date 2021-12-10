package service;

import entity.Student;

import java.sql.*;

public class editService {
    /**
     *根据id获取学生信息
     */
    public Student getStuById(String id) {
        Student stu=new Student();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:33066/studentdemo?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
            String name = "root";
            String pwd = null;
            Connection conn = DriverManager.getConnection(url, name, pwd);
            String sql = "select * from stu where id="+id;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                stu.setId(rs.getInt("id"));
                stu.setSno(rs.getString("sno"));
                stu.setName(rs.getString("name"));
            }
            rs.close();
            stm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return stu;
    }
}


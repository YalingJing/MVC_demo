package service;

import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class addService {
    /**
     *插入学生信息
     */
    public int insertStu(Student stu){
        int ret=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:33066/studentdemo?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
            String name = "root";
            String pwd = null;
            Connection conn = DriverManager.getConnection(url, name, pwd);
            String sql="insert into stu(sno,name)values('"+stu.getSno()+"','"+stu.getName()+"')";
            Statement stm=conn.createStatement();
            ret=stm.executeUpdate(sql);
            stm.close();
            conn.close();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
}

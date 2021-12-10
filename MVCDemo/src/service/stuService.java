package service;

import entity.Student;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author 8613890794742
 */
public class stuService {
    /**
     查询数据库
     */
    public ArrayList<Student> getStuList() {
        ArrayList<Student> list=new ArrayList<>();
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println("数据库连接失败1");
            }
            String url = "jdbc:mysql://localhost:33066/studentdemo?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
            String name = "root";
            String pwd = null;
            Connection con = null;
            try {
                con = DriverManager.getConnection(url, name, pwd);
            } catch (SQLException e) {
                System.out.println("数据库连接失败2");
            }
            String sql = "select * from stu";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                Student stu=new Student();
                stu.setId(rs.getInt("id"));
                stu.setSno(rs.getString("sno"));
                stu.setName(rs.getString("name"));
                list.add(stu);
            }
            rs.close();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

package service;

import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 8613890794742
 */
public class updateService {
    /*
    更新学生信息
     */
    public int updateStu(Student stu) throws ClassNotFoundException {
        int ret = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:33066/studentdemo?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
            String name = "root";
            String pwd = null;
            Connection con = DriverManager.getConnection(url, name, pwd);
            String sql = "update `stu` set `sno`='" + stu.getSno() + "',`name`='" + stu.getName() + "' where id='" + stu.getId() +"'";
            Statement stm = con.createStatement();
            ret = stm.executeUpdate(sql);
            stm.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ret;

    }
}

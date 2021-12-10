package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteService {
    /**
     *删除指定id号的学生
     */
    public int deleteStu(String id){
        int ret=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:33066/studentdemo?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
            String name = "root";
            String pwd = null;
            Connection conn = DriverManager.getConnection(url, name, pwd);
            String sql="delete from stu where id="+id;
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

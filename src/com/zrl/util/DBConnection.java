package com.zrl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public Connection getConnection()
    {
        String url = "jdbc:mysql://172.19.10.238:3306/email?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "sa.123456";
        Connection conn = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("驱动加载出错");
        }
        catch(SQLException e)
        {
            System.out.println("数据库连接出错");
        }
        return conn;

    }
    public void close(ResultSet rs,PreparedStatement p,Connection conn)
    {
        try
        {
            rs.close();
            p.close();
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println("数据库关闭出错");
        }
    }

}

package com.neu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 *数据库连接工具类
 *请不要修改代码
 *
 */
public class DBUtil {
	/**
	 * 
	 * 获得数据库连接对象
	 * @return 数据库连接对象
	 */
	public static Connection  getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/xwebdb";
		String user = "root";
		String password = "512619";
		Connection con=null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	/**
	 * 关闭数据库连接对象
	 * @param conn 数据库连接对象
	 */
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection conn=getConnection();
		System.out.println(conn);
		closeConnection(conn);
	}
}

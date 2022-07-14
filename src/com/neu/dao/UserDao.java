package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.User;
import com.neu.util.DBUtil;

/**
 * 对应user表的持久层
 */
public class UserDao {
	/**
	 * 根据用户名查找用户一条记录
	 * @param userName 用户名字
	 * @return User 用户Bean
	 */
	public User getUserByName(String userName) {
		//代码编写处

		User user = null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from user where userName=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userName);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User(rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
		return user;//请修改代码
	}
	
	/**
	 * 所有用户表的信息
	 * @return 用户列表
	 */
	public List<User> getAll() {
		//代码编写处
		List<User> list = new ArrayList<User>();
		User user = null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from user";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString(2),rs.getString(3));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
		
		return list;//请修改代码
	}

}

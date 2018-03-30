package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import util.DBHelper;
import entity.Users;

public class UsersDAO {
	
	// 获得所有的用户信息
	public ArrayList<Users> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Users> list = new ArrayList<Users>(); // 用户信息集合
		try 
		{
			conn = DBHelper.getConnection();  //获取连接对象
			String sql = "select * from systemuser;"; // SQL语句
			stmt = conn.prepareStatement(sql);  //创建一个连接对象，传入sql
			rs = stmt.executeQuery();  //获得一个数据集
			while (rs.next()) {
				Users user = new Users();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list.add(user);// 把一个用户的信息加入集合list
			}
			return list; // 返回集合。
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return null;
		} 
		finally 
		{
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
   //判断登录
   public boolean usersLogin(Users u){
	    Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from systemuser where username=?and password=?";// SQL语句
			stmt = conn.prepareStatement(sql);	
			
			stmt.setString(1,u.getUsername());
	        stmt.setString(2,u.getPassword());
			rs = stmt.executeQuery();
			if (rs.next()) {
                return true;
            } else {
                return false;
            }
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}   
   }
   
   //修改用户的密码
   public int updateUserPassWord(Users  user) {
		int a=0;
		Connection conn = null;
		String sql = "update systemuser set password=? where username=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getUsername());
			a= pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return a;
	}
   
   
}

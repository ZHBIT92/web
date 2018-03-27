package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import util.DBHelper;
import entity.Users;

public class UsersDAO {
	
	// ������е��û���Ϣ
	public ArrayList<Users> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Users> list = new ArrayList<Users>(); // �û���Ϣ����
		try 
		{
			conn = DBHelper.getConnection();  //��ȡ���Ӷ���
			String sql = "select * from systemuser;"; // SQL���
			stmt = conn.prepareStatement(sql);  //����һ�����Ӷ��󣬴���sql
			rs = stmt.executeQuery();  //���һ�����ݼ�
			while (rs.next()) {
				Users user = new Users();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPower(rs.getInt("power"));
				user.setSex(rs.getString("sex"));
				user.setText(rs.getString("text"));
				list.add(user);// ��һ���û�����Ϣ���뼯��list
			}
			return list; // ���ؼ��ϡ�
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return null;
		} 
		finally 
		{
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
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
	
   //�жϵ�¼
   public boolean usersLogin(Users u){
	    Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from systemuser where username=?and password=?";// SQL���
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
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
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
   
   public boolean addUser(Users user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		boolean flag = false;	
		try {
			conn = DBHelper.getConnection();  //��ȡ���Ӷ���
			String sql = "insert into systemuser(username,password,power,sex,text)"+"values(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setInt(3, user.getPower());
			stmt.setString(4, user.getSex());
			stmt.setString(5, user.getText());
			int i = stmt.executeUpdate(); //����sql������ִ�гɹ��ļ�¼������ int	
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
   
   public boolean delUser(int id) {
		boolean flag = false;
		Connection conn = null;
		String sql = "delete from systemuser where userid=?";
		try {
			conn = DBHelper.getConnection();  //��ȡ���Ӷ���
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			if (psmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
   
   //�޸��û�������
   public int updateUserPassWord(Users  user) {
		int a=0;
		Connection conn = null;
		String sql = "update systemuser set password=? where username=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			a= pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return a;
	}
   
   
}

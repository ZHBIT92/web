package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBHelper;
import entity.Student;

public class StudentDAO {
	
	
	public Student findStudentByid(int id) {
		Student stu = null;
		Connection conn = null;
		String sql = "select * from student where stId=?";
		try {
			conn = DBHelper.getConnection();  //��ȡ���Ӷ���
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int stId = rs.getInt("stId");
				String stName = rs.getString("stName");
				String stSex = rs.getString("stSex");
				String stAge = rs.getString("stAge");
				Long stTel = rs.getLong("stTel");
				String stDept = rs.getString("stDept");
				String stAddress = rs.getString("stAddress");
				stu = new Student(stId, stName, stSex, stAge, stTel, stDept,
						stAddress);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}
	
	public boolean addStudent(Student stu) {
		Connection conn = null;
		PreparedStatement stmt = null;
		// Student(stId,stName,stSex,stAge,stTel,stDept,stAddress)
		boolean flag = false;	
		try {
			conn = DBHelper.getConnection();  //��ȡ���Ӷ���
			String sql = "insert into student(stName,stSex,stAge,stTel,stDept,stAddress)"+"values(?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, stu.getStName());
			stmt.setString(2, stu.getStSex());
			stmt.setString(3, stu.getStAge());
			stmt.setLong(4, stu.getStTel());
			stmt.setString(5, stu.getStDept());
			stmt.setString(6, stu.getStAddress());
			int i = stmt.executeUpdate(); //����sql������ִ�гɹ��ļ�¼������ int	
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public boolean delStudent(int id) {
		boolean flag = false;
		Connection conn = null;
		String sql = "delete from student where stId=?";
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
	
	public boolean updateStudent(Student stu) {
		Connection conn = null;
		boolean flag = false;
		String sql = "update student set stName=?,stSex=?,stAge=?,stTel=?,stDept=?,stAddress=? where stId=? ";
		try {
			conn = DBHelper.getConnection();  //��ȡ���Ӷ���
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, stu.getStName());
			psmt.setString(2, stu.getStSex());
			psmt.setString(3, stu.getStAge());
			psmt.setLong(4, stu.getStTel());
			psmt.setString(5, stu.getStDept());
			psmt.setString(6, stu.getStAddress());
			psmt.setInt(7, stu.getStId());

			int i = psmt.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public List StSelect() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Student> list = new ArrayList<Student>(); // ѧ����Ϣ����
		try 
		{
			conn = DBHelper.getConnection();  //��ȡ���Ӷ���
			String sql = "select * from student;"; // SQL���
			stmt = conn.prepareStatement(sql);  //����һ�����Ӷ��󣬴���sql
			rs = stmt.executeQuery();  //���һ�����ݼ�
			while (rs.next()) {
				int stId = rs.getInt("stId");
				String stName = rs.getString("stName");
				String stSex = rs.getString("stSex");
				String stAge = rs.getString("stAge");
				Long stTel = rs.getLong("stTel");
				String stDept = rs.getString("stDept");
				String stAddress = rs.getString("stAddress");

				Student stu = new Student(stId, stName, stSex, stAge, stTel,
						stDept, stAddress);
				list.add(stu);
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
}

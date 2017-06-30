package edu.cumt.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.cumt.bean.Student;
import edu.cumt.util.DBUtil;

public class StudentDao {
	//获取全部注册学生信息
	public static ArrayList<Student> findAllStudent(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Student> list = null;
		Student stu = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from student");
			rs = ps.executeQuery();
			list = new ArrayList<Student>();
			while(rs.next()){
				stu = new Student();
				stu.setId(Integer.parseInt(rs.getString(1)));
				stu.setName(rs.getString(2));
				stu.setPassword(rs.getString(3));
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return list;
	}
	
	//验证学生登录信息,并返回通过验证的完整的学生信息
	public static Student verify(Student s){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from student where name=? and password=?");
			ps.setString(1, s.getName());
			ps.setString(2, s.getPassword());
			rs = ps.executeQuery();
			if(rs.next()){
				stu = new Student();
				stu.setId(Integer.parseInt(rs.getString(1)));
				stu.setName(rs.getString(2));
				stu.setPassword(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return stu;
	}
	
	//学生注册
	public static boolean register(Student s){
		for (Student stu : findAllStudent()) {
			if(s.getName().equals(stu.getName())){
				return false;  //存在返回false
			}
		}
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into student(name,password) values(?,?)";
			ps = conn.prepareStatement(sql);		//预编译SQL
			ps.setString(1, s.getName());
			ps.setString(2, s.getPassword());
//			System.out.println(sql);
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println("新注册了一个新生："+s.getName());
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(null, ps,conn); 
		}
		return flag;
	}
	
	//修改学生密码
	public static Student reset(Student s,String newpwd){
		Connection conn = null;
		PreparedStatement ps= null;
		Student stu = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update student set password=? where name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newpwd);
			ps.setString(2, s.getName());
			int i = ps.executeUpdate();
			if(i>0){
				stu = s;
				stu.setPassword(newpwd);
				System.out.println(s.getName()+"将密码修改为："+newpwd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(null, ps, conn);
		}
		return stu;
	}
}

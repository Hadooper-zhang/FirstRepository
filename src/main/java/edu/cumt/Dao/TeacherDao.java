package edu.cumt.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.cumt.bean.Student;
import edu.cumt.bean.Teacher;
import edu.cumt.util.DBUtil;

public class TeacherDao {
	//获取所有老师信息
	public static ArrayList<Teacher> findAllTeacher(){
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from teacher");
			rs = ps.executeQuery();
			ArrayList<Teacher> list = new ArrayList<Teacher>();
			Teacher teacher = null;
			while(rs.next()){
				teacher = new Teacher();
				teacher.setId(Integer.parseInt(rs.getString("t_id")));
				teacher.setName(rs.getString("t_name"));
				teacher.setJob(rs.getString("t_job"));
				teacher.setExperience(rs.getString("t_experience"));
				list.add(teacher);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		return null;
	}
	//登录验证
	public static Teacher verify(Teacher t){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher th = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from teacher where t_name=? and t_pwd=?");
			ps.setString(1, t.getName());
			ps.setString(2, t.getPassword());
			rs = ps.executeQuery();
			if(rs.next()){
				th = t;
				th.setId(Integer.parseInt(rs.getString(1)));
				th.setExperience(rs.getString("t_experience"));
				th.setJob(rs.getString("t_job"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		return th;
	}
	public static ArrayList<Student> findClassStudent(Teacher t){
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("");		//通过老师的ID获取选课学生信息
			ps.setString(1, t.getId()+"");
			rs = ps.executeQuery();
			ArrayList<Student> list = new ArrayList<Student>();
			Student stu = null;
			while(rs.next()){
				stu = new Student();
				stu.setId(Integer.parseInt(rs.getString("id")));
				stu.setName(rs.getString("name"));
				list.add(stu);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		return null;
	}
}

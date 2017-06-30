package edu.cumt.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.cumt.bean.Course;
import edu.cumt.bean.Student;
import edu.cumt.bean.Teacher;
import edu.cumt.util.DBUtil;

public class CourseDao {
	public static ArrayList<Course> getAllCourse(Student s){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course c = null;
		ArrayList<Course> list = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT c.c_id,c.c_name,t.t_name,t.t_job FROM course c INNER JOIN teacher t ON c.c_t_id=t.t_id WHERE c.c_id NOT IN (SELECT ct.ct_c_id FROM coursetable ct WHERE ct.ct_stu_id=?) ORDER BY c.c_id";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getId());
			rs = ps.executeQuery();
			list = new ArrayList<Course>();
			while(rs.next()){
				c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return list;
	}
	//添加课程到个人课表
	public static boolean addCourse(Student s,int cid){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into coursetable(ct_stu_id,ct_c_id) values(?,?)");
			ps.setInt(1, s.getId());
			ps.setInt(2, cid);
			int i = ps.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null, ps, conn);
		}
		return false;
	}
	
	public static ArrayList<Course> getMyCourse(Student s){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course c = null;
		ArrayList<Course> list = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("SELECT c.c_id,c.c_name,t.t_name,t.t_job FROM course c INNER JOIN teacher t ON c.c_t_id=t.t_id WHERE c.c_id IN (SELECT ct.ct_c_id FROM coursetable ct WHERE ct.ct_stu_id=?) ORDER BY c.c_id");
			ps.setInt(1, s.getId());
			rs = ps.executeQuery();
			list = new ArrayList<Course>();
			while(rs.next()){
				c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return list;
	}
	public static boolean removeCourse(Student s,int cid){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("DELETE FROM coursetable  WHERE ct_stu_id=? AND ct_c_id=?");
			ps.setInt(1, s.getId());
			ps.setInt(2, cid);
			int i = ps.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null, ps, conn);
		}
		return false;
	}
	
	public static ArrayList<Course> queryScore(Student s){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course c = null;
		ArrayList<Course> list = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("SELECT c.c_id,c.c_name,ct.score FROM coursetable ct INNER JOIN course c ON c.c_id=ct.ct_c_id WHERE ct.ct_c_id IN (SELECT ct.ct_c_id FROM coursetable ct WHERE ct.ct_stu_id=?) AND ct.ct_stu_id=? order by c.c_id");
			ps.setInt(1, s.getId());
			ps.setInt(2, s.getId());
			rs = ps.executeQuery();
			list = new ArrayList<Course>();
			while(rs.next()){
				c = new Course();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setScore(rs.getInt(3));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return list;
	}
	//添加分数
	public static boolean setScore(Teacher t,int sid,String cname,int score){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("UPDATE coursetable ct SET score=? WHERE ct.ct_c_id IN (SELECT a.ct_c_id FROM (SELECT ct.ct_c_id FROM coursetable ct INNER JOIN course c ON ct.ct_c_id=c.c_id WHERE c.c_t_id=? AND ct.ct_stu_id=? AND c.c_name=?) a) AND ct.ct_stu_id=?");
			ps.setInt(1, score);
			ps.setInt(2, t.getId());
			ps.setInt(3, sid);
			ps.setString(4, cname);
			ps.setInt(5, sid);
			int i = ps.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null, ps, conn);
		}
		return false;
	}
	
	//获取自己课程的学习
	public static ArrayList<Course> getMyStudents(Teacher t){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course c = null;
		ArrayList<Course> list = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("SELECT s.id,s.name,c.c_name,ct.score FROM student s INNER JOIN coursetable ct ON s.id=ct.ct_stu_id INNER JOIN course c ON ct.ct_c_id=c.c_id WHERE c.c_t_id=? order by s.id");
			ps.setInt(1, t.getId());
			rs = ps.executeQuery();
			list = new ArrayList<Course>();
			while(rs.next()){
				c = new Course();
				c.setCid(rs.getInt(1));
				c.setTname(rs.getString(2));
				c.setCname(rs.getString(3));
				c.setScore(rs.getInt(4));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return list;
	}
}

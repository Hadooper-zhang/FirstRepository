package edu.cumt.service;

import java.util.ArrayList;

import edu.cumt.Dao.CourseDao;
import edu.cumt.bean.Course;
import edu.cumt.bean.Student;
import edu.cumt.bean.Teacher;

public class CourseService {
	public static ArrayList<Course> showselectCourse(Student s){
		return CourseDao.getAllCourse(s);
	}
	
	public static boolean addCourse(Student s,String cid){
		int cid1 = Integer.parseInt(cid);
		return CourseDao.addCourse(s, cid1);
	}
	
	public static ArrayList<Course> showMyCourse(Student s){
		return CourseDao.getMyCourse(s);
	}
	
	public static boolean removeCourse(Student s,String cid){
		int i = Integer.parseInt(cid);
		return CourseDao.removeCourse(s, i);
	}
	
	public static ArrayList<Course> queryScore(Student s){
		return CourseDao.queryScore(s);
	}
	
	public static ArrayList<Course> getMyStudents(Teacher t){
		return CourseDao.getMyStudents(t);
	}
	
	public static boolean setScore(Teacher t,String sid,String cname,String score){
		int sc = Integer.parseInt(score);
		int id = Integer.parseInt(sid);
		
		return CourseDao.setScore(t, id, cname, sc);
	}
}

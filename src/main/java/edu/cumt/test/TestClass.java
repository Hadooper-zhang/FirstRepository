package edu.cumt.test;

import java.util.ArrayList;

import org.junit.Test;

import edu.cumt.Dao.CourseDao;
import edu.cumt.Dao.StudentDao;
import edu.cumt.bean.Course;
import edu.cumt.bean.Student;
import edu.cumt.bean.Teacher;
import edu.cumt.service.CourseService;

public class TestClass {
	@Test
	public void test1(){
		ArrayList<Student> list = StudentDao.findAllStudent();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	@Test
	public void test2(){
		Student s = new Student();
		s.setName("tom");
		s.setPassword("123");
		Student stu = StudentDao.verify(s);
		System.out.println(stu);
	}
	
	@Test
	public void test3(){
		Student s = new Student();
		s.setName("小强");
		s.setPassword("123");
		boolean b = StudentDao.register(s);
		System.out.println(b);
	}
	@Test
	public void test4(){
		Student s = new Student();
		s.setName("小强");
		s.setPassword("456");
		Student stu = StudentDao.reset(s, "123");
		System.out.println(stu);
	}
	@Test
	public void test5(){
		Student s = new Student();
		s.setId(1);
		ArrayList<Course> list = CourseDao.getAllCourse(s);
		for (Course c : list) {
			System.out.println(c);
		}
	}
	@Test
	public void test6(){
		Student s = new Student();
		s.setId(1);
		ArrayList<Course> list = CourseService.queryScore(s);
		for (Course c : list) {
			System.out.println(c);
		}
	}
	
	@Test
	public void test7(){
		Teacher t = new Teacher();
		t.setId(102);
		ArrayList<Course> list = CourseService.getMyStudents(t);
		for (Course c : list) {
			System.out.println(c);
		}
	}
	@Test
	public void test8(){
		Teacher t = new Teacher();
		t.setId(102);
		int i = 1;
		
	}
}


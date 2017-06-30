package edu.cumt.service;

import edu.cumt.Dao.StudentDao;
import edu.cumt.bean.Student;

public class StudentService {
	public static Student studentLog(Student s){
		return StudentDao.verify(s);
	}
	
	public static boolean studentRegister(Student s){
		return StudentDao.register(s);
	}
	
	public static boolean isExist(String name){
		for (Student stu : StudentDao.findAllStudent()) {
			if(name.equals(stu.getName())){
				return true;
			}
		}
		return false;	
	}
	
	public static Student resetPwd(Student s,String newpwd){
		return StudentDao.reset(s, newpwd);
	}
}

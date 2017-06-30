package edu.cumt.service;

import edu.cumt.Dao.TeacherDao;
import edu.cumt.bean.Teacher;

public class TeacherService {
	public static Teacher teacherLog(Teacher t){
		return TeacherDao.verify(t);
	}
}

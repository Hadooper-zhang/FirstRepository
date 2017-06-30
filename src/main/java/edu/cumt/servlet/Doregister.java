package edu.cumt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.apache.commons.beanutils.BeanUtils;

import edu.cumt.Dao.StudentDao;
import edu.cumt.bean.Student;
import edu.cumt.service.StudentService;

public class Doregister extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Student stu = new Student();
		try {
			BeanUtils.populate(stu, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(stu);
		boolean flag = StudentService.studentRegister(stu);
		if(flag){
			out.print("注册成功");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/log.html");
		}else{
			out.print("注册失败");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/register.jsp");
		}
	}

}

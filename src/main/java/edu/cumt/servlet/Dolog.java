package edu.cumt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.commons.beanutils.BeanUtils;

import edu.cumt.bean.Student;
import edu.cumt.bean.Teacher;
import edu.cumt.service.SecurityCodeService;
import edu.cumt.service.StudentService;
import edu.cumt.service.TeacherService;

public class Dolog extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//获取表单数据
			//对比验证码
		String securitycode = request.getParameter("securityCode");
		Cookie[] cookies = request.getCookies();
		if(!(SecurityCodeService.codeIsTrue(securitycode,cookies))){
			out.print("验证码错误！请重新登录！3秒后跳回登录界面");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/log.html");
		}
		
		String person = request.getParameter("person");
		if("student".equals(person)){
			Student stu = new Student();
			try {
				BeanUtils.populate(stu, request.getParameterMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
			//调用业务逻辑
			stu = StudentService.studentLog(stu);
			if(stu!=null){
				System.out.println(stu.getName()+"同学登录了系统！");
				request.getSession().setAttribute("user", stu);
				//跳转至学生主页
				request.getRequestDispatcher("/WEB-INF/1.jsp").forward(request, response);
			}
		}
		
		if("teacher".equals(person)){
			Teacher th = new Teacher();
			try {
				BeanUtils.populate(th, request.getParameterMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
			//调用业务逻辑
			th = TeacherService.teacherLog(th);
			if(th!=null){
				System.out.println(th.getName()+"老师登录了系统！");
				request.getSession().setAttribute("user", th);
				//跳转至教师主页
				request.getRequestDispatcher("/WEB-INF/teacherCenter.jsp").forward(request, response);
			}
		}
		out.print("用户名或密码错误！请重新登录！3秒后跳回登录界面");
		response.setHeader("refresh", "3;url="+request.getContextPath()+"/log.html");
	}

}

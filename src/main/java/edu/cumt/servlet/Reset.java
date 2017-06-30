package edu.cumt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cumt.bean.Student;
import edu.cumt.service.StudentService;

public class Reset extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//huoqushuju
		String oldpwd = request.getParameter("password");
		String newpwd = request.getParameter("newpassword");
		
		//验证原密码
		
		Student stu = (Student)request.getSession().getAttribute("user");
		if(!(oldpwd.equals(stu.getPassword()))){
			request.setAttribute("msg", "原密码错误！");
			request.getRequestDispatcher("/WEB-INF/6.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "");
			//调用业务逻辑
			stu = StudentService.resetPwd(stu, newpwd);
			//转发
			if(stu!=null){
				out.print("<script>alert('修改成功，请重新登录！');window.location.href='"+request.getContextPath()+"/log.html';</script>");
			}else{
				out.print("<script>alert('系统错误！');window.location.href='"+request.getContextPath()+"/log.html';</script>");
			}
		}
		
		
	}

}

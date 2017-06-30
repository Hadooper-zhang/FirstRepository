package edu.cumt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cumt.bean.Student;
import edu.cumt.service.CourseService;

public class SelectCourse extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		Student s = (Student)request.getSession().getAttribute("user");
		if(CourseService.addCourse(s, id)){
			out.print("<script>alert('添加成功！');</script>");
			request.getRequestDispatcher("/WEB-INF/3.jsp").forward(request, response);
		}else{
			out.print("<script>alert('添加失败！');</script>");
			request.getRequestDispatcher("/WEB-INF/3.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}

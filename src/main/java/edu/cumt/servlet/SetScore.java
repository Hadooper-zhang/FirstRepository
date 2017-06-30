package edu.cumt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cumt.bean.Teacher;
import edu.cumt.service.CourseService;

public class SetScore extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String score = request.getParameter("score");
		String sid = request.getParameter("sid");
		String cname = request.getParameter("cname");
		Teacher t = (Teacher)request.getSession().getAttribute("user");
		System.out.println(cname);
		boolean b = CourseService.setScore(t, sid, cname, score);
		if(b){
			System.out.println("成绩上传成功！");
			request.getRequestDispatcher("/WEB-INF/teacherCenter.jsp").forward(request, response);
		}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package edu.cumt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoChangePage extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		int i = Integer.parseInt(id)+1;
		if(i==7){
			request.getSession().invalidate();
			out.print("<script>alert('注销成功！');window.location.href='"+request.getContextPath()+"/log.html';</script>");
		}else{
			request.getRequestDispatcher("/WEB-INF/"+i+".jsp").forward(request, response);
		}
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}

<%@page import="edu.cumt.bean.Course"%>
<%@page import="edu.cumt.service.CourseService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的课程列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/css2.css">
  </head>
  
  <body>
    <div class="container">
    		<%@ include file="base.jsp" %>
	    	<div class="content">
	    		<h3 style="text-align:center;line-height:80px;">我的课程列表</h3>
	    		<table border=1 cellspacing=0 style="margin-left:100px;">
					<tr><td>课程编号</td><td>课程名</td><td>授课老师</td><td>职称</td><td>移除课程</td></tr>
					<% 
						
						ArrayList<Course> list = CourseService.showMyCourse(stu);
						if(list!=null){
							for(Course c:list){
								/* out.println("<p>"+teacher+"</p>"); */
								%>
								<tr><td><%=c.getCid() %></td><td><%=c.getCname() %></td><td><%=c.getTname() %></td><td><%=c.getTjob() %></td>
								<td><a href="${pageContext.request.contextPath }/servlet/removeCourse?id=<%=c.getCid() %>">移出我的课表</a></td></tr>
								<%
							}
						}
					%>
				</table>
	    	</div>
    	</div>
  </body>
</html>

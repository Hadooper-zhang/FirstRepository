<%@page import="edu.cumt.Dao.TeacherDao"%>
<%@page import="edu.cumt.bean.Teacher"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>师资介绍</title>
    
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
    	<h3 style="text-align:center;line-height:150px;">教师团队</h3>
    	<table border=1 cellspacing=0>
		<tr><td>name</td><td>job</td><td>experience]</td></tr>
		<% 
			ArrayList<Teacher> list = TeacherDao.findAllTeacher();
			if(list!=null){
				for(Teacher t:list){
					/* out.println("<p>"+teacher+"</p>"); */
					%>
					<td><%=t.getName() %></td><td><%=t.getJob() %></td><td><%=t.getExperience() %></td></tr>
					<%
				}
			}
		%>
	</table>
	    	</div>
    	</div>
  </body>
</html>

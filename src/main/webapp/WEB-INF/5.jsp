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
    
    <title>课程成绩</title>
    
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
	    		<h3 style="text-align:center;line-height:80px;">已修课程成绩</h3>
	    		<table border=1 cellspacing=0 style="margin-left:100px;">
					<tr><td>课程编号</td><td>课程名</td><td>课程成绩</td></tr>
					<% 
						
						ArrayList<Course> list = CourseService.queryScore(stu);
						if(list!=null){
							for(Course c:list){
								%>
								<tr><td><%=c.getCid() %></td><td><%=c.getCname() %></td><td><%=(c.getScore()==0?"考核中":c.getScore()) %></td></tr>
								<%
							}
						}
					%>
				</table>
				<p style="top:30px;line-height:50px;">注：成绩显示考核中的科目表示该课程未结课或者老师正在评分中，请耐心等待！</p>
	    	</div>
    	</div>
  </body>
</html>

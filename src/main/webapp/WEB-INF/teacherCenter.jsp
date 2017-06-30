<%@page import="edu.cumt.bean.Course"%>
<%@page import="edu.cumt.service.CourseService"%>
<%@page import="edu.cumt.bean.Student"%>
<%@page import="edu.cumt.Dao.TeacherDao"%>
<%@page import="edu.cumt.bean.Teacher"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理中心</title>
<style type="text/css">
	#logout{
		cursor:pointer;
	}
	#logout:hover{
		font-weight:bold;
		color:red;
	}
</style>
</head>
<body>
	<%
		Teacher th = (Teacher)session.getAttribute("user");
	 %>
	<h1>欢迎你！<%=th.getName() %>老师</h1>
	<%-- <p><a href="${pageContext.request.contextPath }/servlet/dologout ">注销</a></p> --%>
	<p><span id="logout">注销</span></p>
	<hr>
	<h3>教师团队</h3>
	<table border=1 cellspacing=0>
		<tr><td>t_id</td><td>name</td><td>job</td><td>experience]</td></tr>
		<% 
			ArrayList<Teacher> list = TeacherDao.findAllTeacher();
			if(list!=null){
				for(Teacher t:list){
					/* out.println("<p>"+teacher+"</p>"); */
					%>
					<tr><td><%=t.getId() %></td><td><%=t.getName() %></td><td><%=t.getJob() %></td><td><%=t.getExperience() %></td></tr>
					<%
				}
			}
		%>
	</table>
	<hr>
	<h3>参加课程学生信息</h3>
	<table border=1 cellspacing=0 id="tb">
		<tr><td>学生id</td><td>学生姓名</td><td>课程名称</td><td>分数</td><td>上传分数</td></tr>
		<% 
			ArrayList<Course> list1 = CourseService.getMyStudents(th);
			if(list1!=null){
				for(Course c:list1){
					%>
					<tr><td><%=c.getCid() %></td><td><%=c.getTname() %></td><td><%=c.getCname() %></td><td><%=(c.getScore()==0?"还未上传成绩":c.getScore()) %></td>
					<td><input type="text" style="width:80px;" name="sc"><button name="bt">提交</button></td></tr>
					<%
				}
			}
		%>
	</table>
	<script type="text/javascript">
		window.onload=function(){
			//给学生上传成绩
			var tb = document.getElementById("tb");
    		var bt = document.getElementsByName("bt");
    		var sc = document.getElementsByName("sc");
    		for (var i = 0; i < bt.length; i++) {
    			bt[i].index=i;
    			bt[i].onclick=function(){
    				/* alert(sc[this.index].value); */
    				var r = confirm("是否提交成绩？");
    				if(r==true){
    					var x = tb.rows[this.index+1].cells;
    					window.location.href="${pageContext.request.contextPath }/servlet/setScore?score="+sc[this.index].value+"&sid="+x[0].innerHTML+"&cname="+x[2].innerHTML;
    				}
    			};
    		}
    		
    		//注销事件函数
    		var logout = document.getElementById("logout");
    		logout.onclick=function(){
    			var r = confirm("确定退出登录？");
    			if(r==true){
    				window.location.href="${pageContext.request.contextPath }/servlet/dologout ";
    			}
    		};


    	};
	</script>
	
</body>
</html>
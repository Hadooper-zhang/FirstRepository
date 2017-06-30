<%@page import="edu.cumt.bean.Student"%>
<%@ page pageEncoding="UTF-8" %>
<%
	Student stu = (Student)session.getAttribute("user");
 %>
<div class="banner">
	<script type="text/javascript">
		window.onload=function(){
			var mli = document.getElementsByClassName("mli");
			var logout = document.getElementById("logout");
    		for (var i = 0; i < mli.length; i++) {
    			mli[i].index=i;
    			mli[i].onclick=function(){
    				/* alert(this.index); */
    				if(this.index==6){
    					var r = confirm("确定退出登录？");
    					if(r==true){
    						window.location.href="${pageContext.request.contextPath }/servlet/dologout ";
    					}
    				}else{
    					window.location="${pageContext.request.contextPath }/servlet/doChangePage?id="+this.index;
    				}
    			};
    		};
		};
	</script>
    			<h1>Welcome To Log In StudentSystem</h1>
    			<p>欢迎你：<%=stu.getName() %>同学</p>
    		</div>
	    	<div class="menu">
	    		<ul>
	    			<li class="mli">学校简介</li>
	    			<li class="mli">师资水平</li>
	    			<li class="mli">学生选课</li>
	    			<li class="mli">我的课程</li>
	    			<li class="mli">结课成绩</li>
	    			<li class="mli">修改密码</li>
	    			<li class="mli">注销</li>
	    		</ul>
	    	</div>

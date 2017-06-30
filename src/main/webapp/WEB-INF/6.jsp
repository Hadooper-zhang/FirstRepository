<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改个人密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/css2.css">
	<script src="js/jquery.js"></script>
  </head>
  
  <body>
    <div class="container">
    		<%@ include file="base.jsp" %>
	    	<div class="content">
	    		<h3 style="text-align:center;line-height:100px;">登录密码修改</h3>
	    		<div style="width:350px;height:80px;margin:50px auto;">
	    			<form action="${pageContext.request.contextPath }/servlet/reset" method="post" >
	    			<table>
	    			<tr><td>用户名:</td><td><%=stu.getName() %></td></tr>
	    			<tr><td>原密码：</td><td><input type="password" name="password" id="psw"></td><td style="color:red;">${msg }</td></tr>
	    			<tr style="display:none;"><td>新密码：</td><td><input type="password" name="newpassword"></td></tr>
	    			<tr><td></td><td><button type="submit" onclick="return doreset();" id="bto" >修改</button></td></tr>
	    			</table>
	    		</form>
	    		</div>
	    	</div>
    	</div>
    <script type="text/javascript">
    	var psw = document.getElementsByName("password")[0];
    	function doreset(){
    		var newpsw = document.getElementsByName("newpassword")[0];
    		var a = prompt("请输入新密码");
			var b = prompt("请再输入新密码");
	  		if(a==b & a!=null){
	  			newpsw.value = a;
	  			//alert(newpsw.value);
	  			return true;
	  		}else{
	  			alert("两次密码不一致");
	  			return false;
	  		}
    	}
    	
    	/* psw.onmouseout = function(){
    		var bto = document.getElementById("bto");
    		var p = document.getElementsByName("password")[0];
    		if(p.value!=null){
    			bto.disabled=false;
    		}else{
    			bto.disabled=true;
    		}
    	} */
    	/* $("#psw").change(function(event){
    	alert($(this).val());
    		if($(this).val()==null){
    		alert(1);
    			$("#bto").attr("disabled","true");
    		}else{
    			$("#bto").attr("disabled","false");
    		}
    	}); */
    	
    </script>
  </body>
</html>

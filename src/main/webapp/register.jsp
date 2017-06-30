<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script>
		window.onload=function(){
			var nameElement = document.getElementsByName("name")[0];
			nameElement.onblur = function(){
				var name = this.value;//this等价于nameElement
				//创建XMLHttpRequest对象
			var xhr;
			try{
				xhr = new XMLHttpRequest();
			}catch(e){
				try {
					xhr = new ActiveXObject("MSxml2.XMLHTTP");
				} catch (e) {
					try {
						xhr = ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {
					}
				}
			}
			//处理结果
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4){//请求一切正常
					if(xhr.status==200){//服务器响应一切正常
						//alert(xhr.responseText);//得到响应结果
						var msg = document.getElementById("msg");
						if(xhr.responseText=="true"){
							msg.innerHTML =  "用户名已存在！";
							msg.style.color="red";
						}else{
							msg.innerHTML = "用户名可用！";
							msg.style.color="green";
						}
					}
				}
			}
			
			//创建连接
			xhr.open("get","${pageContext.request.contextPath }/servlet/ckName?name="+name);
			//发送请求
			xhr.send(null);
			}
		}
	</script>
</head>
<body>
	<div style="width:500px;height:120px;margin:200px auto;">
		<form action="servlet/doregister" method="post">
    		<table>
    			<tr><td>用户名：</td><td><input type="text" name="name"></td></td><td><span id="msg"></span></td></tr>
    			<tr><td>密码：</td><td><input type="password" name="password"></tr>
    			<tr><td></td><td><button value="submit" style="width: 50px" >注册</button></td></tr>
    		</table>
    	</form>
	</div>
</body>
</html>
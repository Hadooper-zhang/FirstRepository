<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生个人首页</title>
    
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
	    		<img src="img/20170418142836.png" height="300" width="900" alt="冲击年薪50万">
	    	<p style="line-height:25px;">&nbsp&nbsp北风网，创立5年多来，致力于中国IT互联网教育的前沿，讲师来源于各大IT公司的技术总监、项目经理、资深架构师和各大知名培训机构。
北风网已获得某国际著名风投公司的A轮投资。这也是目前国内IT在线企业中首家获得A轮以上规模投资的企业。国际著名投资机构的专业眼光，令人信服地证明了北风网在IT在线教育行业内无可争议的主导地位！
课程定位: IT技术的前沿，为企业提供优秀的能动手的精英人才！
课程内容：用商业化的项目去塑造网站，用商业化的项目去教会我们的学员如何面对未来的职场！
课程目标：提升每个IT人的专业水平，为中国的IT技术的发展贡献一份微薄之力。
课程优势：低廉的培训费用、高效的培训项目、全新的讲课理念，手把手的项目，用我们的思维去引导学员去如何大胆的走出去。
课程价值：绝不用简单的项目去忽悠学生，绝不用重复的思想去教授学生，绝不用落后的技术去讲课！
我们的口号:没有最新的理念是锻造不出一个IT人应有的素质！时刻适当时代步伐,不断变幻前进的步伐！
适用人群：在校大学生、应届毕业生、IT人充电、IT人跳槽等。</p>
	    	</div>
    	</div>
  </body>
</html>

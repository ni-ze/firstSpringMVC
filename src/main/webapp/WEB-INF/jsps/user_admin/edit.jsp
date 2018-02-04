<%@ page language="java" 
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录送积分网</title>

<%-- <link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main.css"
	type="text/css" /> --%>
</head>
<body>
	<div id="main">
 	   <div class="newcontainer" id="course_intro">
		  <form name="mainForm" action="<%= request.getContextPath()%>/loading/save" method="post">
		    <div>
		       <span>请输入用户名：</span><input type="text" id="userName" name="userName">
		    </div>
		    <div>
		       <span>请输入登陆密码：</span><input type="text" id="password" name="password"> 
		    </div>  
 
		    <div>
		       <input type="submit" id="btnPass" value="登陆" /> <!--登陆到loading下的save方法-->
		    </div> 
		  </form>
		</div>  
	</div>
</body>
</html>
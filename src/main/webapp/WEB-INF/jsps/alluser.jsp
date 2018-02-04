<%@ page language="java" 
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html> 
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>用户信息列表</title>  
</head>
<body>
	<table border="1">    
     <tr>  
        <th>序号</th> 
        <th>用户名</th> 
        <th>创建时间</th> 
        <th>积分</th>
     </tr>
      
     	<c:forEach items="${userList }" var="User">
			<tr>  
				<td>${User.id }</td>  
				<td><a href="<c:url value="/loading/checkforeachone/${User.userName }"/>">${User.userName }</a></td>
				<td>${User.createTime }</td>   
           	 	<td>${User.point }</td> 
            </tr>
		</c:forEach> 
      

	 
	</table>
</body>
</html> 


<span style="font-size:18px;"><%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html> 
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>用户信息</title>  
</head>  
<body>  
    <table border="1">  
        <tr>  
            <th>用户名</th>  
            <th>密码</th> 
             <th>积分</th>
        </tr>  
        <tr>  
            <td>${userBack.userName }</td>  
            <td>${userBack.password }</td> 
            <td>${userBack.point }</td> 
        </tr>  
    </table>  
</body>  
</html></span>  
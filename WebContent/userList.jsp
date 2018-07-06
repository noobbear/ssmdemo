<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath()+"/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<th>id</th>
		<th>学号</th>
		<th>姓名</th>
		<th>操作</th>
	</tr>
	
	<c:forEach items="${userList}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.sno}</td>
			<td>${user.sname}</td>
			<td>
				<a href="user/getUserById/${user.id}">编辑</a>
				<a href="user/deleteUser/${user.id}">删除</a>
			</td>
		</tr>
	</c:forEach>
	
</table>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
User Id:${user.id}<br>
User Name:${user.name}<br>
<strong>Blogs</strong><br>
<c:forEach items="${user.blogs}" var="blog">
	Blog Name:${blog.name}<br>
	Blog Url:${blog.url}<br>
		<table>
		<thead>
		<tr><th> Title </th><th> Link </th></tr>
		</thead>
		<tbody>
		<c:forEach items="${blog.items}" var="item" >
		
		<tr><td>${item.title}</td><td>${item.link}</td></tr>
		
		</c:forEach>
		</tbody>
		</table>
</c:forEach>
</body>
</html>
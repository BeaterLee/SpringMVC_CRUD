<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:message key="user"></fmt:message>
	<a href="password">password</a><br>
	<a href="user?locale=zh_CN">中文</a><br>
	<a href="user?locale=en_US">English</a><br>
</body>
</html>
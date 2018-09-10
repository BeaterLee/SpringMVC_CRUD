<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 字符串格式： lastName-email-gender-department.id -->
<form action="${pageContext.request.contextPath}/testConverter" method="post">
	<input type="text" name="employee">
	<input type="submit" value="submit">
</form>
</body>
</html>
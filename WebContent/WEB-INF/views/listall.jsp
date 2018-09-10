<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employee</title>
<script type="text/javascript" src="scripts/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function() {
		$(".delete").click(function(){
			$("form").attr("action",$(this).attr("href")).submit();
			return false;
		})
	})
</script>
</head>
<body>
	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE">
	</form>
	<c:if test="${empty employees}">
		没有雇员信息！
	</c:if>
	<c:if test="${!empty employees}">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>lastName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${requestScope.employees}" var="employee">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.lastName}</td>
					<td>${employee.email}</td>
					<td>${employee.gender == 1 ? "male" : "female"}</td>
					<td>${employee.department.departmentName}</td>
					<td><a class="edit" href="${pageContext.request.contextPath}/employee/${employee.id}">Edit</a></td>
					<td><a class="delete" href="${pageContext.request.contextPath}/employee/${employee.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<a class="add" href="${pageContext.request.contextPath}/employee">addEmployee</a>
</body>
</html>
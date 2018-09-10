<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/employee/${employee.id}" method="post" modelAttribute="employee">
		<input type="hidden" name="_method" value="PUT">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>email</td>
				<td><form:input path="email"></form:input></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:radiobuttons path="gender" items="${genders}" /></td>
			</tr>
			<tr>
				<td>Department</td>
				<!-- 如果items是一个bean的Map，那么可以使用bean内的属性值为itemLabel和itemValue赋值。假如items不是bean的Map，那么默认为itemLabel赋值为Map.Value,itemValue赋值为Map.Key -->
				<td><form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id"></form:select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
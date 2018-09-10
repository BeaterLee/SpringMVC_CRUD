<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addEmployee</title>
</head>
<body>
	<!--
 	使用spring提供的form标签，可以简化表单开发，方便表单回显 
 	可以通过modelAttribute属性指定绑定的模型属性，若没有指定该属性，则默认从request 域对象中读取command的表单bean，如果该属性值也不存在，则会发生错误
 	假如传入的模型对象的属性中带了值，则会为表单填充这些值
 -->
	<form:form action="${pageContext.request.contextPath}/employee" method="post" modelAttribute="employee">
		<table border="1" cellpadding="10" cellspacing="0">
			<c:if test="${employee.id == null}">
				<tr>
					<td>lastName</td>
					<td><form:input path="lastName"></form:input><form:errors path="lastName"></form:errors></td>
				</tr>
			</c:if>
			<c:if test="${employee.id != null}">
				<form:hidden path="id"/>
				<input type="hidden" name="_method" value="PUT">
			</c:if>
			<tr>
				<td>email</td>
				<td><form:input path="email"></form:input><form:errors path="email"></form:errors></td>
			</tr>
			<tr>
				<td>birth</td>
				<td><form:input path="birth"></form:input><form:errors path="birth"></form:errors></td>
			</tr>
			<tr>
				<td>salary</td>
				<td><form:input path="salary"></form:input></td>
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
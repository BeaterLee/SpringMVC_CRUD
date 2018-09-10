<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#json").click(function() {
			alert($(this).attr("href"));
			var url = $(this).attr("href");
			var args = {
				"a" : $(this).text()
			};
			$.post(url, args, function(data) {
				for (var i = 0; i < data.length; i++) {
					alert(data[i]);
				}
			})
			return false;
		})
	})
</script>
</head>
<body>
	<a href="${pageContext.request.contextPath}/listAll">listAll</a>
	<a href="${pageContext.request.contextPath}/testExceptionHandler?i=2">testExceptionHandler</a>
	<a href="${pageContext.request.contextPath}/testResposeStatusExceptionHandler?i=2">testResposeStatusExceptionHandler</a>
	<a href="${pageContext.request.contextPath}/testDefaultHandlerExceptionResolver">testDefaultHandlerExceptionResolver</a>
	<a href="${pageContext.request.contextPath}/testSimpleMappingExceptionResolver?i=2">testSimpleMappingExceptionResolver</a>
	<a id="json" href="${pageContext.request.contextPath}/testJson">testJson</a>
</body>
</html>
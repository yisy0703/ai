<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- 지시자 : page, include, taglib(9장에서) -->
	<%
		int[] arr = {1,2,3};
		out.print(Arrays.toString(arr));
	%>
	<hr>
	<jsp:include page=""></jsp:include>
</body>
</html>

















<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet">
</head>
<body>
	<!-- 1. ex6_gugudanResult.jsp 에서 정답/오답 출력 -->
	<!-- 2. ex6_gugudanQuiz.jsp 한 파일에서 에서 정답/오답 출력 -->
	<form action="ex6_gugudanResult.jsp">
		<p>
			<input type="text" name="n1" readonly="readonly" size="1"
						value="<%=(int)(Math.random()*9+1)%>">
			<b>*</b>
			<input type="text" name="n2" readonly="readonly" size="1"
						value="<%=(int)(Math.random()*9)+1 %>">
			<b>=</b>
			<input type="number" name="result" placeholder="정답입력">
		</p>
		<p>
			<input type="submit" value="확인">
		</p>
	</form>
</body>
</html>










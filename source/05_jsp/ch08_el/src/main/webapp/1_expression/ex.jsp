<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet">
</head>
<body>
	<h2>표현식 태그</h2>
	<p>산술연산 <%=10+1 %></p>
	
	<h2>el표기법(표현식 안에 쓸 수 있는 연산자는 다 사용 가능)</h2>
	<p>산술연산 ${10+1 }</p>
</body>
</html>
















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
	<%
		String[] names = {"홍길동","김길동","신길동" };
		for(String name : names){
			out.println("<p>" + name + "</p>");
		}
		for(int idx=0 ; idx<names.length ; idx++){
			out.println("<p>" + idx + "번째 " + names[idx] + " </p>");
		}
		request.setAttribute("names", names); // 자바측에서 뷰단에 출력할 내용을 setAttribute
	%>
	<hr>
	<c:forEach var="name" items="${names }">
		<p>${name }</p>
	</c:forEach>
	<c:set var="idx" value="0"/> <!-- idx변수에 0으로 초기화하여 선언 -->
	<c:forEach var="name" items="${names }">
		<p>${idx}번째 ${name }</p>
		<c:set var="idx" value="${idx+1 }"/> <!-- idx변수를 재선언 : idx += 1 -->
	</c:forEach>
</body>
</html>














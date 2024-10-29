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
	<%--
		int visitNum = Integer.parseInt(request.getParameter("visitNum"));
		if(visitNum == 1){
			out.print("첫 방문 감사합니다");
		}else if(visitNum>1 && visitNum <=5){
			out.print("많이 많이 방문해 주세요");
		}else if(visitNum > 5) {
			out.print("많이 방문해 주셔서 감사합니다");
		}
	--%>
	<!-- 입력된 방문 횟수(param.visitNum)에 따라 메세지를 달리 출력 -->
	<c:set var="visitNum" value="${param.visitNum }"/> <!-- 변수 선언 -->
	<c:if test="${visitNum eq 1 }">
		<h3>첫 방문 감사합니다</h3>
	</c:if>
	<c:if test="${visitNum>1 && visitNum<=5 }">
		<h3>많이 많이 방문해 주세요</h3>
	</c:if>
	<c:if test="${visitNum >5 }">
		<h3>많이 방문해 주셔서 감사합니다</h3>
	</c:if>
	<c:if test="${empty visitNum }">
		<h3>visitNum 파라미터를 받지 못했습니다</h3>
	</c:if>
</body>
</html>














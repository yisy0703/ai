<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/ex.css" rel="stylesheet">
	<script src="${conPath }/js/memberInfo.js"></script>
</head>
<body>
	<form action="${conPath }/memberJoin.do" method="post">
		<table>
			<caption>회원가입</caption>
			<tr>
				<th><label for="id">아이디</label></th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th><td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<th>비밀번호</th><td><input type="password" name="pwChk"></td>
			</tr>
			<tr>
				<th>이름</th><td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>생년월일</th><td><input type="date" name="birth"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="회원가입" onclick="infoConfirm()" class="btn">
					<input type="reset" value="이전" onclick="history.back()" class="btn">
					<input type="button" value="회원목록"
					             onclick="location.href='${conPath}/memberList.do'" class="btn"> 
				</td>
			</tr>
		</table>
	</form>
</body>
</html>















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
</head>
<body>
	<c:if test="${not empty insertMsg }">
		<script>alert("${insertMsg}");</script>
	</c:if>
	<c:if test="${not empty deleteMsg }">
		<script>alert('${param.id}번 '+'${deleteMsg}')</script>
	</c:if>
	<table>
		<tr>
			<th colspan="4">
				<a href="${conPath }/">처음으로</a> &nbsp;
				<a href="${conPath }/insert.do">지인 추가</a>
			</th>
		</tr>
		<tr><th>ID</th><th>이름</th><th>전화</th><th>생일</th></tr>
		<c:if test="${empty personList || personList.size() eq 0}">
			<tr><td colspan="4">해당 데이터가 없습니다</td></tr>
		</c:if>
		<c:forEach var="person" items="${personList }">
			<tr onclick="location.href='${conPath}/info.do?id=${person.id }&pageNum=${pageNum }'">
				<td>${person.id }</td>
				<td>${person.name }</td>
				<td>${person.tel }</td>
				<td>
					<fmt:formatDate value="${person.birth }" pattern="MM월 dd일"/>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			[ <a href="${conPath }/list.do?pageNum=${startPage-1}">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${pageNum eq i }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${pageNum != i }">
				<a href="${conPath }/list.do?pageNum=${i}">[ ${i } ]</a>
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			[ <a href="${conPath }/list.do?pageNum=${endPage+1}">다음</a> ]
		</c:if>
	</div>
</body>
</html>













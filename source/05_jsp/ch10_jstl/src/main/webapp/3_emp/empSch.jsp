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
	<script>
		window.onload = ()=>{
			document.querySelector('input[name="schName"]').onkeyup = function(){
				if(this.value.trim())
					document.querySelector('form').submit();
			};
			document.querySelector('input[name="schJob"]').onkeyup = function(){
				if(this.value.trim())
					document.querySelector('form').submit();
			};
		};
	</script>
</head>
<body>
	<form action="">
		<p>
			이름 
			<input type="text" name="schName" 
							value="${param.schName.toUpperCase().trim() }">
			직책 
			<input type="text" name="schJob" 
							value="${param.schJob.toUpperCase().trim() }">
			<input type="submit" value="검색">
		</p>
	</form>
	<table>
		<tr>
			<th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>
			<th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th>
		</tr>
		<c:if test="${empList.size() eq 0 }">
			<tr><td colspan="8">검색된 사원이 없습니다</td></tr>
		</c:if>
		<c:forEach var="emp" items="${empList }">
			<tr>
				<td>${emp.empno }</td> <!-- el표기법에서 emp.empno는 emp.getEmpno() -->
				<td>
					<c:if test="${emp.sal >=3000 }">
						<img src="${conPath }/img/hot.gif" alt="hot">
					</c:if>
					<c:if test="${empty emp.mgr }">
						<b style="color:red;">${emp.ename }</b>
					</c:if>
					<c:if test="${not empty emp.mgr }">
						${emp.ename }
					</c:if>
				</td>
				<td>${emp.job }</td>
				<td>${empty emp.mgr ? "CEO":emp.mgr }</td>
				<td>
					<fmt:formatDate value="${emp.hiredate }" pattern="yyyy년MM월dd일(E)"/>
				</td>
				<td>
					<fmt:formatNumber value="${emp.sal }" pattern="#,###.#"/>
				</td>
				<td>
					<fmt:formatNumber value="${emp.comm }" groupingUsed="true"/>(3자리마다 콤마)
				</td>
				<td>${emp.deptno }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>














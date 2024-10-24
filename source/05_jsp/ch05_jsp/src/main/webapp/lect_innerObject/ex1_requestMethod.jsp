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
	<h2>요청한 곳의 주소 : <%=request.getRemoteAddr() %></h2>
	<h2>컨텍스트 패스 : <%=request.getContextPath() %></h2>
	<h2>요청 URL : <%=request.getRequestURL() %></h2>
	<h2>요청 URI : <%=request.getRequestURI() %></h2>
	<h2>포트번호 : <%=request.getServerPort() %></h2>
</body>
</html>












`
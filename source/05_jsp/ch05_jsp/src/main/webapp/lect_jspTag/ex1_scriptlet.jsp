<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%
		String color = request.getParameter("color");
		if(color==null){
			color = "#FFFFDD";
		}
	%>
	<style>
		body{background-color: <%=color%>; }
	</style>
</head>
<body>
	<h1>배경색 바꾸기</h1>
	<form action="">
		<select name="color">
			<option value="red" <%if(color.equals("red")) out.print("selected='selected'");%>>빨강</option>
			<option value="orange" <%if(color.equals("orange")) out.print("selected='selected'");%>>주황</option>
			<option value="yellow" <%if(color.equals("yellow")) out.print("selected='selected'");%>>노랑</option>
			<option value="green" <%if(color.equals("green")) out.print("selected='selected'");%>>초록</option>
			<option value="blue" <%if(color.equals("blue")) out.print("selected='selected'");%>>파랑</option>
			<option value="navy" <%if(color.equals("navy")) out.print("selected='selected'");%>>남색</option>
			<option value="violet" <%if(color.equals("violet")) out.print("selected='selected'");%>>보라</option>
		</select>
		<input type="submit" value="적용">
	</form>
</body>
</html>














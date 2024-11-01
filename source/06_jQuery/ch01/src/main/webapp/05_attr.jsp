<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$('img').mousedown(function(){
				$(this).attr('src','img/but2.gif'); // src의 속성 변경
				$(this).attr('alt','마우스다운');
			});
			$('img').mouseup(function(){
				$(this).attr('src','img/but1.gif'); // src의 속성 변경
				$(this).attr('alt','마우스업');
			});
		});		
	</script>
</head>
<body>
	<img src="img/but1.gif" alt="마우스업">
	<img src="img/but1.gif" alt="마우스업">
	<img src="img/but1.gif" alt="마우스업">
	<img src="img/but1.gif" alt="마우스업">
	<img src="img/but1.gif" alt="마우스업">
</body>
</html>









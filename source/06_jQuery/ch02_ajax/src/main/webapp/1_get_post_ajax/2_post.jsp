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
			/*$.get(요청경로, callback)  
				$.post(요청경로, 요청파라미터값의 객체, callback)
			*/
			$('button').click(function(){
				var id = $('input[name="id"]').val();
				$.post('midConfirm.jsp',
							{id : id},
							function(data, status){
								$('span#idConfirm').html(data);
							}
				); // post함수
				
			}); // click함수
			$('input[name="id"]').keyup(function(){
				var id = $(this).val();
				if(id.length < 3){
					$('span#idConfirm').text('id는 3글자 이상');
				}else{
					$.post('midConfirm.jsp',
							{id : id},
							function(data, status){
								$('span#idConfirm').html(data);
							}
					); // post함수
				}//if
			});// keyup
			
			
		});	// ready함수
	</script>
</head>
<body>
	아이디 <input type="text" name="id" autocomplete="off"> <button>중복체크</button><br>
	<span id="idConfirm"></span>
</body>
</html>






<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<style>
		
	</style>
</head>
<body>
	<!-- index.jsp -->
	<h1>WebSocket <small>chat</small></h1>
	
	<div>
		<div class="group">
			<label>대화명</label>
			<input type="text" name="name" id="name" class="short">
		</div>
	</div>
	<div>
		<button type="button" class="in">들어가기</button>
		
		<button type="button" class="in" data-name="강아지">들어가기(강아지)</button>
		
		<button type="button" class="in" data-name="고양이">들어가기(고양이)</button>
		
		<button type="button" class="in" data-name="병아리">들어가기(병아리)</button>
		
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
	
		$('.in').click(()=>{
			
			//let name = $('#name').val();
			
			let name = $(event.target).data('name');
			
			if (name == null || name == '') {
				name = $('#name').val();
			} else {
				$('#name').val(name);
			}			
			
			const child = window.open('/socket/chat.do', 'chat', 'width=406, height=518');
			
			$('#name').prop('readOnly', true);
			$('.in').prop('disabled', true);
			$(event.target).css('opacity', .5);
			
			/* 
			setTimeout(() => {
				child.connect(name);				
			}, 3000); 
			*/
			
			//onload 이벤트 > DOM을 전부 로딩한 후에 발생
			child.addEventListener('load', () => {
				child.connect(name);
			});
			
		});
	
	</script>
</body>
</html>













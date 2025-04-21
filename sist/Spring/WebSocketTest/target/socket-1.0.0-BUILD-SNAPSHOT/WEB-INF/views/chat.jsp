<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<style>
		html, body {
			padding: 0 !important;
			margin: 0 !important;
			background-color: #FFF !important; 
			display: block;
			overflow: hidden;
		}
		
		body > div {
			margin: 0; 
			padding: 0; 
		}
	
		#main {
			width: 400px;
			height: 510px;
			margin: 3px;
			display: grid;
			grid-template-rows: repeat(12, 1fr);
		}
		
		#header {
		
		}
		
		#header > h2 {		
			margin: 0px;
			margin-bottom: 10px;
			padding: 5px;
		}
	
		#list {
			border: 1px solid var(--border-color);
			box-sizing: content-box;
			padding: .5rem;
			grid-row-start: 2;
			grid-row-end: 12;
			font-size: 14px;
			overflow: auto;
		}
		
		#msg {
			margin-top: 3px;
		}
		
		#list .item {
			font-size: 14px;
			margin: 15px 0;
		}
		
		#list .item > div:first-child {
			display: flex;
		}
		
		#list .item.me > div:first-child {
			justify-content: flex-end;
		}
		
		#list .item.other > div:first-child {
			justify-content: flex-end;
			flex-direction: row-reverse;
		}
		
		#list .item > div:first-child > div:first-child {
			font-size: 10px;
			color: #777;
			margin: 3px 5px;
		}
		
		#list .item > div:first-child > div:nth-child(2) {
			border: 1px solid var(--border-color);
			display: inline-block;
			min-width: 100px;
			max-width: 250px;
			text-align: left;
			padding: 3px 7px;
		}
		
		#list .state.item > div:first-child > div:nth-child(2) {
			background-color: #EEE;
		}
		
		#list .item > div:last-child {
			font-size: 10px;
			color: #777;
			margin-top: 5px;
		}
		
		#list .me {
			text-align: right;
		}
		
		#list .other {
			text-align: left;
		}
		
		#list .msg.me.item > div:first-child > div:nth-child(2) {
			background-color: rgba(255, 99, 71, .2);
		}
		
		#list .msg.other.item > div:first-child > div:nth-child(2) {
			background-color: rgba(100, 149, 237, .2);
		}
		
		#list .msg img {
			width: 150px;
		}
	</style>
</head>
<body>
	<!-- chat.jsp -->
	<div id="main">
		<div id="header"><h2>WebSocket <small></small></h2></div>
		<div id="list"></div>
		<input type="text" id="msg" placeholder="대화 내용을 입력하세요.">
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/dayjs@1.11.13/dayjs.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
	
		/*  
			클라이언트 <- (전송) -> 서버
			
			메시지 형식 > 프로토콜 설계
			- code: 상태코드
				- 1: 새로운 유저가 들어옴
				- 2: 기존 유저가 나감
				- 3: 메시지 전달
			- sender: 메시지를 보낸 유저명
			- receiver: 메시지를 받는 유저명(1:1 채팅, 귓속말)
			- content: 메시지(대화 내용)
			- regdate: 날짜/시간
				
		*/
	
		let name; //대화명
		let ws; //소켓
		const url = 'ws://localhost:8090/socket/chatserver.do';
		
		//창 > 서버와 자동으로 연결하기
		function connect(name) {
			
			//대화명 출력하기
			$('#header small').text(name);
			
			//연결하기(+소켓 생성)
			ws = new WebSocket(url);
			log('채팅서버에게 연결을 시도합니다.');
		
			//소켓 이벤트 추가
			ws.onopen = evt => {
				log('채팅서버와 연결이 되었습니다.');
				
				//내가 누군지를 알려주자!!
				//- 접속한 유저명을 서버에게 전달
				const message = {
					code: '1',
					sender: name,
					receiver: '',
					content: '',
					regdate: dayjs().format('YYYY-MM-DD HH:mm:ss') 
				};
				
				//클라이언트 > (데이터 전송) > 서버
				ws.send(JSON.stringify(message));
				
			};
			
			ws.onmessage = evt => {};
			
			ws.onclose = evt => {
				log('채팅서버와의 연결을 종료합니다.');
			};
			
			ws.onerror = evt => {
				log(evt);
			};
			
		}
		
		function log(msg) {
			console.log(dayjs().format('HH:mm:ss'), msg);
		}
	
	</script>
</body>
</html>





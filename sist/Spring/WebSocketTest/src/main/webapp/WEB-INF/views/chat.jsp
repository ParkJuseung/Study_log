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
		
		#list .secret.me.item > div:first-child > div:nth-child(2) {
			background-color: gold;
		}
		
		#list .secret.other.item > div:first-child > div:nth-child(2) {
			background-color: gold;
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
				- 3: (전역)메시지 전달
				- 4: (귓속말)메시지 전달
				- 5: (전역)이모티콘 전달
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
			
			ws.onmessage = evt => {
				log('채팅서버로부터 메시지가 도착했습니다.');
				
				//evt.data = {"code":"1", "sender":"강아지", "receiver":"", "content":"" ,"regdate":"2025-04-21 14:09:12"}
				
				//자바스크립트 객체 > JSON 문자열
				//문자열 = JSON.stringify(객체);
				
				//JSON 문자열 > 자바스크립트 객체
				let message = JSON.parse(evt.data);
				
				console.log('message', message);
				
				if (message.code == '1') {
					print('', `[\${message.sender}]님이 들어왔습니다.`, 'other', 'state', message.regdate);
				} else if (message.code == '2') {
					print('', `[\${message.sender}]님이 나갔습니다.`, 'other', 'state', message.regdate);
				} else if (message.code == '3') {
					print(message.sender, message.content, 'other', 'msg', message.regdate);
				} else if (message.code == '4') {
					print(message.sender, message.content, 'other', 'secret', message.regdate);
				} else if (message.code == '5') {
					printEmoticon(message.sender, message.content, 'other', 'msg', message.regdate);
				}
				
				scrollList();
				
			};
			
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
		
		function print(name, msg, side, state, time) {
			
			let temp = `
			<div class="item \${state} \${side}">
				<div>
					<div>\${name}</div>
					<div>\${msg}</div>
				</div>
				<div>\${time}</div>
			</div>		
			`;
			
			$('#list').append(temp);
			
		}
		
		//창을 닫기 직전
		$(window).on('beforeunload', function() {
			
			//opener.document.title = '창닫음';
			
			$(opener.document).find('.in').css('opacity', 1)
										   .prop('disabled', false);
			$(opener.document).find('#name').val('')
										   .prop('readOnly', false);
			
			disconnect();
			
		});
		
		function disconnect() {
			
			//현재 사용자 나가기
			const message = {
				code: '2',
				sender: $('#header small').text(),
				receiver: '',
				content: '',
				regdate: dayjs().format('YYYY-MM-DD HH:mm:ss') 
			};
			
			ws.send(JSON.stringify(message));
			
			ws.close();//대화방 나가기
			
		}
		
		//F5 금지, Ctrl + R 금지
		window.onkeydown = () => {
			if (event.keyCode == 116
				|| (event.ctrlKey && event.keyCode == 82)) {
				event.preventDefault();
				return false;
			}
		};
		
		/* 
		btn1.onclick = function() {
			event.keyCode
		};
		
		btn1.onclick = function(evt) {
			evt.keyCode
		} 
		*/
		
		
		$('#msg').keydown(evt => {
			
			if (evt.keyCode == 13) {
				
				//- 안녕하세요.
				//- /고양이 안녕하세요.
				//- /고양이 #심쿵
				//- /고양이 #심쿵 안녕하세요.
								
				const regex = /^\/\S{1,}/;
				const regex2 = /^#[가-힣]{1,}$/;
				
				const regex3 = /^\/\S{1,}\s#[가-힣]{1,}$/;
				const regex4 = /^\/\S{1,}\s#[가-힣]{1,}/;
				
				//alert(regex.test($(event.target).val()));				
				
				if (regex.test($(event.target).val())) {
					const message = {
						code: '4',
						sender: $('#header small').text(),
						receiver: $(event.target).val().split(' ')[0].substr(1),
						content: $(event.target).val().substr($(event.target).val().indexOf(' ') + 1),
						regdate: dayjs().format('YYYY-MM-DD HH:mm:ss') 
					};
					
					ws.send(JSON.stringify(message));
					
					print(message.sender, message.content, 'me', 'secret', message.regdate);
					
					$(event.target).val('').focus();
					scrollList();
				} else if (regex2.test($(event.target).val())) {
					
					//이모티콘
					const message = {
						code: '5',
						sender: $('#header small').text(),
						receiver: '',
						content: $(event.target).val(), //- /궁금
						regdate: dayjs().format('YYYY-MM-DD HH:mm:ss') 
					};
					
					ws.send(JSON.stringify(message));
					
					printEmoticon(message.sender, message.content, 'me', 'msg', message.regdate);
					
					$(event.target).val('').focus();
					scrollList();
					
				} else {
					
					//일반 텍스트 메시지
					const message = {
						code: '3',
						sender: $('#header small').text(),
						receiver: '',
						content: $(event.target).val(),
						regdate: dayjs().format('YYYY-MM-DD HH:mm:ss') 
					};
					
					ws.send(JSON.stringify(message));
					
					print(message.sender, message.content, 'me', 'msg', message.regdate);
					
					$(event.target).val('').focus();
					scrollList();
				}
				
			}
			
		});
		
		function scrollList() {
			$('#list').scrollTop($('#list')[0].scrollHeight + 300);
		}		
		
		function printEmoticon(name, msg, side, state, time) {
			let temp = `
				<div class="item \${state} \${side}">
					<div>
						<div>\${name}</div>
						<div style='background-color: #FFF;border: 0;'><img src='/socket/resources/emoticon/\${msg.substr(1)}.png'></div>
					</div>
					<div>\${time}</div>
				</div>		
				`;
				
			$('#list').append(temp);
			
			setTimeout(scrollList, 100);
		}
		
	
	</script>
</body>
</html>










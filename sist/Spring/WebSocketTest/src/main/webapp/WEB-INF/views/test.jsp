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
	<!-- test.jsp -->
	<h1>WebSocket <small>사용법</small></h1>
	
	<div>
		<button type="button" id="btn-connect">연결하기</button>
		<button type="button" id="btn-disconnect">종료하기</button>
	</div>
	
	<hr>
	
	<div>
		<input type="text" class="long" id="msg">
		<button type="button" id="btn-echo">에코 테스트</button>
	</div>
	
	<hr>
	
	<div class="message full"></div>
	
	<script src="https://cdn.jsdelivr.net/npm/dayjs@1.11.13/dayjs.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
	
		//서버측 종단점(주소)
		//const url = 'ws://echo.websocket.org';
		const url = 'ws://localhost:8090/socket/server.do';
		
		//웹소켓
		let ws;
		
		$('#btn-connect').click(()=>{
			
			if (ws != null && ws.readyState == 1) {
				log('이미 서버와 연결되었습니다.');
				return;
			}
			
			//1. 소켓 생성
			//2. 서버 접속(연결)
			//3. 통신
			//4. 서버 접속 종료
			
			//1. 소켓 생성 + 2. 서버 접속
			ws = new WebSocket(url); //전화 걸기
			log('소켓 상태: ' + ws.readyState);
			
			//ws.readyState
			//0: 연결 전
			//1: 연결 완료(***)
			//2: 연결 종료 중
			//3: 연결 종료
			
			
			//소켓 이벤트 > 이벤트 함수 등록
			
			//서버측에서 소켓 연결 요청을 수락 후 > 서로 연결이 되는 순간
			ws.onopen = evt => {
				log('서버와 연결되었습니다.');
				log('소켓 상태: ' + ws.readyState);
			};
			
			//상대방이 나에게 메시지를 전달하는 순간 > 내가 수신하는 순간
			ws.onmessage = evt => {
				log('서버로부터 받은 데이터: ' + evt.data);
			};
			
			//상대방과 소켓 연결이 끊기는 순간
			ws.onclose = evt => {
				log('서버와 연결이 종료되었습니다.');
				log('소켓 상태: ' + ws.readyState);
			};
			
			//소켓 통신 에러
			ws.onerror = evt => {
				log('에러가 발생했습니다.');	
			};
			
		});
		
		$('#btn-disconnect').click(()=>{
			
			//소켓 닫기
			ws.close();
			
		});
		
		$('#btn-echo').click(()=>{
			
			if (ws == null || ws.readyState != 1) {
				log('서버와 연결이 안되었습니다.');
				return;
			}
			
			//현재 연결중인 소켓을 사용해서 상대방에게 데이터를 전달하기
			//ws.send('안녕하세요.');
			ws.send($('#msg').val());
			
			log('메시지를 전송했습니다.');
			
		});
		
		function log(msg) {
			$('.message').prepend(`
				<div>[\${dayjs().format('HH:mm:ss')}] \${msg}</div>		
			`);
		}
		
		//[오후 2:30:21] 테스트
		//[14:30:21] 테스트
		//log(dayjs().format('YYYY-MM-DD HH:mm:ss'));
		//log('테스트');
	
	</script>
</body>
</html>









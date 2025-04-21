package com.test.socket.server;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

//종단점(IP + Portnumber) 생성 > http://localhost:8090/
@ServerEndpoint("/server.do")
public class SocketServer {
	
	//클라이언트가 연결 요청을 했을 때 발생
	@OnOpen
	public void handleOpen() {
		System.out.println("클라이언트가 접속했습니다.");
	}
	
	//클라이언트가 메시지를 전송 > 서버가 수신할 때 발생
	@OnMessage
	public String handleMessage(String msg) {
		System.out.println("클라이언트가 보낸 메시지: " + msg);
		return msg; //에코(echo)
	}
	
	//클라이언트와의 연결이 종료될 때 발생
	@OnClose
	public void handleClose() {
		System.out.println("클라이언트와 연결이 종료되었습니다.");
	}
	
	//에러 발생
	@OnError
	public void handlError(Throwable e) {
		System.out.println("에러 발생: " + e.getMessage());
	}

}






















package com.test.socket.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.test.socket.domain.Message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ServerEndpoint("/chatserver.do")
public class ChatServer {
	
	//현재 채팅 서버에서 접속한 모든 클라이언트
	private static List<User> sessionList; // x N(방)
	
	//내부 클래스
	@NoArgsConstructor
	@AllArgsConstructor
	class User {
		public Session session;
		public String name;
	}
	
	static {
		sessionList = new ArrayList<User>();
	}
	
	@OnOpen
	public void handleOpen(Session session) {
		System.out.println("클라이언트가 접속했습니다.");
		
		User user = new User(session, null);
		
		sessionList.add(user);
		
		System.out.println("sessionList: " + sessionList);
	}
	
	@OnMessage
	public void handleMessage(String msg, Session session) {
		
		//{"code":"1", "sender":"강아지", "receiver":"", "content":"" ,"regdate":"2025-04-21 14:09:12"};
		//System.out.println(msg);
		
		//위의 JSON 데이터 > 자바 타입(Message)
		
		Gson gson = new Gson();
		
		Message message = gson.fromJson(msg, Message.class);
		
		System.out.println(message);
		
		if (message.getCode().equals("1")) {
			
			//들어온 당사자
			User user = null;
			
			for (User s : sessionList) {
				if (s.session == session) {
					user = s;
				}
			}
			
			user.name = message.getSender();
			
			
			//새로운 유저가 접속했습니다.
			//- 당사자 빼고 나머지 사람들에게 알려주기
			//- sessionList
			for (User s : sessionList) {
				if (s.session != session) {
					try {
						s.session.getBasicRemote().sendText(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		} else if (message.getCode().equals("2")) {
			
			//유저가 나갔습니다.
			User user = null;
			
			for (User s : sessionList) {
				if (s.session == session) {
					user = s;
				}
			}
			sessionList.remove(user);
			
			for (User s : sessionList) {
				try { 
					s.session.getBasicRemote().sendText(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} else if (message.getCode().equals("3")
					|| message.getCode().equals("5")) {
			
			//모든 사람에게 받은 대화 내용을 전달
			for (User s : sessionList) {
				
				if (s.session != session) {
					try {
						s.session.getBasicRemote().sendText(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		} else if (message.getCode().equals("4")) {
			
			//귓속말 처리
			//- Message(code=4, sender=강아지, receiver=고양이, content=밥먹었니?, regdate=2025-04-21 16:08:48)
			//System.out.println(message);
			
			for (User s : sessionList) {
				
				if (s.name.equals(message.getReceiver())) {
					
					//귓속말 전송
					try {
						s.session.getBasicRemote().sendText(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					break;
				}
				
			}
			
		}

	}
	
	@OnClose
	public void handleClose() {
		System.out.println("클라이언트가 접속 종료했습니다.");
	}
	
	@OnError
	public void handlError(Throwable e) {
		System.out.println(e.getMessage());
	}

}









